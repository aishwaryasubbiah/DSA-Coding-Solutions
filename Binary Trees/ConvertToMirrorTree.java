/* https://www.geeksforgeeks.org/problems/mirror-tree/1 */

/* Approach 1: Using Recursion */ 

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if(node == null) return;
        Node tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        mirror(node.left);
        mirror(node.right);
    }
}

/* Approach 2: Using Queue */ 

class queueData {
    Node rootNode, node;
    int pos;
    queueData(Node rootNode, Node node, int pos) {
        this.rootNode = rootNode;
        this.node = node;
        this.pos = pos;
    }
}

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        Queue<queueData> queue = new LinkedList<>();
        queue.add(new queueData(node, node, 0));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Node currRootNode = queue.peek().rootNode;
                Node currNode = queue.peek().node;
                int currPos = queue.peek().pos;
                queue.remove();
                if(currNode != null) {
                    queue.add(new queueData(currNode, currNode.left, -1));
                     queue.add(new queueData(currNode, currNode.right, 1));
                }
                if(currPos == -1) {
                    currRootNode.right = currNode;
                }
                else if(currPos == 1) {
                    currRootNode.left = currNode;
                }
            }
            
        } 
    }
}