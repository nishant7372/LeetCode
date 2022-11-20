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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }
    
    private int diameter(TreeNode root)
    {
        if(root==null)
            return 0;
        int lHeight = diameter(root.left);
        int rHeight = diameter(root.right);
        if(lHeight+rHeight>max)
            max=lHeight+rHeight;
        return Math.max(lHeight,rHeight)+1;
    }
}
