class Solution {
    private int d1,d2;
    private TreeNode p1,p2;
    public boolean isCousins(TreeNode root, int x, int y) {
        d1=d2=0;
        p1=p2=null;
        depth(root,x,y,0,root);
        if(d1==d2&&p1.val!=p2.val)
            return true;
        return false;
    }
    
    private void depth(TreeNode root,int x,int y,int d,TreeNode parent)
    {
        if(root!=null)
        {
        if(root.val==x)
        {
            p1=parent;
            d1=d;
        }
        if(root.val==y)
        {
            p2=parent;
            d2=d;
        }   
        depth(root.left,x,y,d+1,root);
        depth(root.right,x,y,d+1,root);  
        }
    }
}
