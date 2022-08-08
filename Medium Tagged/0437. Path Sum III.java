class Solution {
    int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        func(root,targetSum);
        return c/2;
    }
    
    private void func(TreeNode root,int targetSum)
    {
        if(root==null)
            return;
        func(root.left,targetSum);
        func(root.right,targetSum);
        generate(root,targetSum,0,0);
    }
    
    private void generate(TreeNode root,int targetSum,long sum,int level)
    {
        if(level!=0&&targetSum==sum)
            c++;
        if(root==null)
            return;
        generate(root.left,targetSum,sum+root.val,level+1);
        generate(root.right,targetSum,sum+root.val,level+1);
    }
}
