class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }
    
    private boolean dfs(TreeNode root,int targetSum)
    {
        if(root==null)
            return false;
        targetSum-=root.val;
        if(isLeaf(root)&&targetSum==0)
            return true;
        boolean b1 = dfs(root.left,targetSum);
        if(b1)
            return true;
        return dfs(root.right,targetSum);
    }
    
    private boolean isLeaf(TreeNode temp)
    {
        if(temp.left==null&&temp.right==null)
            return true;
        return false;
    }
}
