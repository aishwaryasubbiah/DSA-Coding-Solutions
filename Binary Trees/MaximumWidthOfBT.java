/* https://leetcode.com/problems/maximum-width-of-binary-tree/ */

class QueueData {
    TreeNode node;
    int index;
    QueueData(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
} 

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int width = Integer.MIN_VALUE;
        Queue<QueueData> queue = new LinkedList<>();
        queue.add(new QueueData(root, 1));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            int startIndex = 0, endIndex = size;
            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.peek().node;
                int currIndex = queue.peek().index;
                queue.remove();
                if(count == 0) startIndex = currIndex;
                if(count == size-1) endIndex = currIndex;
                count++;
                if(currNode.left != null) queue.add(new QueueData(currNode.left, 2*currIndex));
                if(currNode.right != null) queue.add(new QueueData(currNode.right, (2*currIndex)+1));
            }
            width = Math.max(width, (endIndex - startIndex)+1);
        }
        return width;   
    }
}