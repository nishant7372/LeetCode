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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        TreeNode l = root;
        TreeNode r = root;
        
        int lh = 0;
        int rh = 0;
        
        while(l!=null){
            lh++;
            l = l.left;
        }
        
        while(r!=null){
            rh++;
            r = r.right;
        }
        
        if(rh==lh)
            return (int)Math.pow(2,lh)-1;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
