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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return build(preorder,map,0,preorder.length-1);
    }
    
    int i=0;
    private TreeNode build(int[] preorder,Map<Integer,Integer> map,int start,int end)
    {
        if(start>end)
            return null;
        int data = preorder[i++];
        TreeNode root = new TreeNode(data);
        root.left = build(preorder,map,start,map.get(data)-1);
        root.right = build(preorder,map,map.get(data)+1,end);
        return root;
    }
}
