class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)   // key is not found
            return null;
		//searching for node in the right subtree
        if(root.val<key)
            root.right= deleteNode(root.right,key);
		//searching for node in the left subtree
        else if(root.val>key)
            root.left= deleteNode(root.left,key);
        else{
		// if node has two children  --> replace it with inOrderSuccessor (node with min value in the right subtree)
        if(root.left!=null&&root.right!=null){
            TreeNode minNode = findMin(root.right);
            root.val=minNode.val;
            root.right = deleteNode(root.right,minNode.val);
        }
		// if node has one children
        else if(root.left!=null)
            root = root.left;
		// if node has one children
        else if(root.right!=null)
            root = root.right;
		// if node is a Leaf node
        else
            root=null;
        }
        return root;
    }
    
	// finding node with min value in the right subtree
    private TreeNode findMin(TreeNode root){
        if(root.left==null)
            return root;
        return findMin(root.left);
    }
}
