/* https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1 */

class queueData {
    Node queueNode;
    int index;
    queueData(Node queueNode, int index)
    {
        this.queueNode = queueNode;
        this.index = index;
    }
}

class priorityQueueData {
    int nodeVal, level, index, order;
    priorityQueueData(int nodeVal,int level,int index, int order) {
        this.nodeVal = nodeVal;
        this.level = level;
        this.index = index;
        this.order = order;
    }
}


class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> bottomViewList = new ArrayList<>();
        if(root == null) return bottomViewList;

        Queue<queueData> queue = new LinkedList<queueData>();
        PriorityQueue<priorityQueueData> pq = new PriorityQueue<priorityQueueData>((x,y) -> x.index - y.index);
    
        queue.add(new queueData(root, 0));
        pq.add(new priorityQueueData(root.data, 0, 0, 1));
        int levelCount = 1, order = 2;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i< size; i++)
            {
                Node currNode = queue.peek().queueNode;
                int currIndex = queue.peek().index;
                queue.remove();
                if(currNode.left != null){
                    queue.add(new queueData(currNode.left, currIndex-1));
                    pq.add(new priorityQueueData(currNode.left.data, levelCount, currIndex-1, order));
                    order++;
                } 
                if(currNode.right != null) { 
                    queue.add(new queueData(currNode.right, currIndex+1));
                    pq.add(new priorityQueueData(currNode.right.data, levelCount, currIndex+1,order));
                    order++;
                }
            }
            levelCount++;
        }
        
        while(!pq.isEmpty())
        {
            int currLevel = pq.peek().level;
            int currVal = pq.peek().nodeVal;
            int currIndex = pq.peek().index;
            int currOrder = pq.peek().order;
            pq.remove();
            
            while(!pq.isEmpty() && pq.peek().index == currIndex )
            {
                if(pq.peek().level >= currLevel && pq.peek().order > currOrder) {
                    currVal = pq.peek().nodeVal;
                    currLevel = pq.peek().level;
                    currOrder = pq.peek().order;
                }
                pq.remove();
            }
            bottomViewList.add(currVal);
        }
        return bottomViewList;
    }
}


/* Notes
Use queue for travering the Binary tree
Use priority queue for processing the values based on priority. 
Here we order the priority by its distance
*/