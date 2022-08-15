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
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preorder(root,sb,0);
        return sb.toString();
    }
    
    private void preorder(TreeNode root,StringBuffer sb,int c)
    {
        if(root==null)
        {
            return;
        }
        if(c!=0)
        sb.append("(");
        sb.append(root.val);
        if(root.left==null&&root.right!=null)
            sb.append("()");
        preorder(root.left,sb,c+1);
        preorder(root.right,sb,c+1);
        if(c!=0)
        sb.append(")");
    }
}
