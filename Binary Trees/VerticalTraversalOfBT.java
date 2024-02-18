/* https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/ */

class queueData {
    TreeNode node;
    int index;
    queueData(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
} 

class priorityQueueData {
    int nodeVal, level, index;
    priorityQueueData(int nodeVal,int level, int index) {
        this.nodeVal = nodeVal;
        this.level = level;
        this.index = index;
    }
} 


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<queueData> queue = new LinkedList<>();
        PriorityQueue<priorityQueueData> pq = new PriorityQueue<>((a,b) -> a.index - b.index);
        queue.add(new queueData(root, 0));
        pq.add(new priorityQueueData(root.val, 0, 0));
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i< size; i++) {
                TreeNode currNode = queue.peek().node;
                int currIndex = queue.peek().index;
                queue.remove();
                if(currNode.left != null) {
                    queue.add(new queueData(currNode.left, currIndex-1));
                    pq.add(new priorityQueueData(currNode.left.val, level, currIndex-1));
                }
                if(currNode.right != null) {
                    queue.add(new queueData(currNode.right, currIndex+1));
                    pq.add(new priorityQueueData(currNode.right.val, level, currIndex+1));
                }
            }
            level++;
        }
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();

        while(!pq.isEmpty())
        {
            int currNodeval = pq.peek().nodeVal;
            int currIndex = pq.peek().index;
            int currLevel = pq.peek().level;
            pq.remove();
            ArrayList<Integer> temp = new ArrayList<>();
            Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

            temp.add(currNodeval);
            map.put(currLevel, temp);
            while(!pq.isEmpty() && pq.peek().index == currIndex) {
                int nodeval = pq.peek().nodeVal;
                currLevel = pq.peek().level;
                pq.remove();
                if(map.containsKey(currLevel)) {
                   ArrayList<Integer> existingList = map.get(currLevel);
                   existingList.add(nodeval);
                   map.put(currLevel, existingList);
                } else {
                    ArrayList<Integer> templist = new ArrayList<>();
                    templist.add(nodeval);
                    map.put(currLevel, templist);
                }
            } 
            
            List<Integer> newList = new ArrayList<>();
            for(Integer key : map.keySet()) {
                ArrayList<Integer> currList = map.get(key);
                Collections.sort(currList);
                for(int loop: currList) {
                    newList.add(loop);
                }
            }
            finalList.add(newList);
        }

        return finalList;
    }
}

/* Notes
Using queue, priority queue and TreeMap
*/