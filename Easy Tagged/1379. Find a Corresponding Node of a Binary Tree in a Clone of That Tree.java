/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(original,cloned,target);
    }
    
    private TreeNode find(TreeNode original,TreeNode cloned,TreeNode target)
    {
        if(original==null)
            return null;
        if(original==target)
            return cloned;
        TreeNode ref = find(original.left,cloned.left,target);
        if(ref!=null)
            return ref;
        return find(original.right,cloned.right,target);
    }
}
