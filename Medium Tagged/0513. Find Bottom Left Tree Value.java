//using Integer wrapper class --> 1ms Faster Beats 78.80%

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int max = maxDepth(root);
        return find(root,0,max); 
    }
    
    private Integer find(TreeNode root,int c,int max)
    {
        if(root==null)
           return null; //Integer class (Java) can hold null value.
        if(c==max) //if currDepth == maxDepth
           return root.val;
        //using Integer wrapper class to hold null.
        Integer res = find(root.left,c+1,max); 
        if(res!=null)
           return res;
        return find(root.right,c+1,max);
    }
    
    //finding depth of the tree
    private int maxDepth(TreeNode root)
    {
        if(root==null)
           return -1; 
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth+1,rDepth+1);
    }
}


//using ArrayList --> 1ms Faster Beats 78.80%

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int max = maxDepth(root);
        find(root,0,max,a);
        return a.get(0);
    }
    
    private void find(TreeNode root,int c,int max,ArrayList<Integer> a)
    {
        if(root==null)
           return;
        if(c==max)
           a.add(root.val);
        find(root.left,c+1,max,a);
        find(root.right,c+1,max,a);
    }
    
    private int maxDepth(TreeNode root)
    {
        if(root==null)
           return -1;  
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth+1,rDepth+1);
    }
}

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
