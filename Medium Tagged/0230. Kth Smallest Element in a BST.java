/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//Optimized Approach --> 0ms runtime faster than 100percent
class Solution {
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        return inorder(root);
    }
    
    private int inorder(TreeNode root)
    {
         if(root==null)
            return -1;
         int res = inorder(root.left);
         if(--k==0)
             return root.val;
         if(res==-1)
             return inorder(root.right);
         return res;
    }
}


//1ms runtime
class Solution {
    private int res=-1;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode root)
    {
         if(res!=-1||root==null)
            return;
         inorder(root.left);
         if(--k==0)
             res=root.val;
         inorder(root.right);
    }
}
