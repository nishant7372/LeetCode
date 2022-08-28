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
