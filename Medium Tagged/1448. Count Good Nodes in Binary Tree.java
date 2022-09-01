class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        count(root,root.val);
        return count;
    }
    
    private void count(TreeNode root,int maxSoFar)
    {
        if(root==null)
            return;
        if(check(root.val,maxSoFar))
            count++;
        if(maxSoFar<root.val)
            maxSoFar=root.val;
        count(root.left,maxSoFar);
        count(root.right,maxSoFar);
    }
           
    private boolean check(int data,int maxSoFar)
    {
        if(maxSoFar>data)
        return false;
        return true;
    }
}
