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

// 0ms runtime, Beats 100%

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        calc(root,0);
        return sum;
    }
    
    private void calc(TreeNode root,int num)
    {
        if(root==null)
            return;
        num=num*10+root.val;
        if(isLeaf(root))
         sum+=num;
        calc(root.left,num);
        calc(root.right,num);
    }
    
    private boolean isLeaf(TreeNode root)
    {
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }
}
