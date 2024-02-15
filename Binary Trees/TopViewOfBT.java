/* https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1 */

class queueData{
    Node nodeVal;
    int index;
    queueData(Node nodeVal, int index) {
        this.nodeVal = nodeVal;
        this.index = index;
    }
}

class priorityQueueData{
    int nodeVal, level, index, order;
    priorityQueueData(int nodeVal, int level, int index, int order) {
        this.nodeVal = nodeVal;
        this.level = level;
        this.index = index;
        this.order = order;
    }
}

class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> topViewList = new ArrayList<Integer>();
        if(root == null) return topViewList;
        
        Queue<queueData> queue = new LinkedList<>();
        PriorityQueue<priorityQueueData> pq = new PriorityQueue<priorityQueueData>((a,b) -> a.index - b.index);

        queue.add(new queueData(root, 0));
        pq.add(new priorityQueueData(root.data, 0, 0, 1));
        int levelCount = 1, order = 1; 
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node currNode = queue.peek().nodeVal;
                int currIndex = queue.peek().index;
                queue.remove();
                if(currNode.left != null) {
                    queue.add(new queueData(currNode.left, currIndex-1));
                    pq.add(new priorityQueueData(currNode.left.data, levelCount, currIndex-1, ++order));
                }
                if(currNode.right != null) {
                    queue.add(new queueData(currNode.right, currIndex+1));
                    pq.add(new priorityQueueData(currNode.right.data, levelCount, currIndex+1, ++order));
        
                }
            }
            levelCount++;
        }
        
        while(!pq.isEmpty()) 
        {
            int currVal = pq.peek().nodeVal;
            int currLevel = pq.peek().level;
            int currIndex = pq.peek().index;
            int currOrder = pq.peek().order;
            pq.remove();
            while(!pq.isEmpty() && pq.peek().index == currIndex)
            {
                if(pq.peek().level <= currLevel && pq.peek().order < currOrder) {
                    currLevel = pq.peek().level;
                    currVal = pq.peek().nodeVal;
                    currOrder = pq.peek().order;
                }
                pq.remove();
            }
            topViewList.add(currVal);
        }
        return topViewList;
    }
}

/* Notes
Use queue for travering the Binary tree
Use priority queue for processing the values based on priority. 
Here we order the priority by its distance
*/