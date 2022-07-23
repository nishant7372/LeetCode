class Solution {
    
    int sum1=0;
    public int findTilt(TreeNode root) {
      traverse(root);  
      return sum1;
    }
    
    int sum=0;
    private void traverse(TreeNode root)
    {
        if(root==null)
            return;
        sum=0;
        calc(root.left);
        int a=sum;
        sum=0;
        calc(root.right);
        int b=sum; 
        sum1+= root.val=Math.abs(a-b);
      
        traverse(root.left);
        traverse(root.right);
    }
    
    
    private void calc(TreeNode temp)
    {
        if(temp==null)
            return;
        sum+=temp.val;
        calc(temp.left);
        calc(temp.right);
    }
}
