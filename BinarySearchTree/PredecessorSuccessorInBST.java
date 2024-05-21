/* https://www.geeksforgeeks.org/problems/predecessor-and-successor/1 */

public static void findPreSuc(Node root, int key)
    {
        if(root == null) return;
        if(root.data < key && (pre == null || root.data > pre.data)) pre = root;
        if(root.data > key && (suc == null || root.data < suc.data)) suc = root; 
        findPreSuc(root.left, key);
        findPreSuc(root.right, key);  
    }
