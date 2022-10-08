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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
            return new TreeNode(val,root,null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(depth-->0)
        {
            int len =queue.size();
            for(int i=0;i<len;i++)
            {
            TreeNode currNode = queue.remove();
            if(depth>1){
            if(currNode.left!=null)
                queue.add(currNode.left);
            if(currNode.right!=null)
                queue.add(currNode.right);
            }
            else{
                currNode.left = new TreeNode(val,currNode.left,null);
                currNode.right = new TreeNode(val,null,currNode.right);
            }
            }
        }
        return root;
    }
}
