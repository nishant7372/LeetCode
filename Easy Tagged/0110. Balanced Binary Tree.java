//Method 1 ---> Optimized Faster than 99.1%  (Bottom to Top)

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) ==-1? false:true;
    }
    
    
    private int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int lheight = height(root.left);
        if(lheight==-1)
            return -1;
        int rheight = height(root.right);
        if(rheight==-1)
            return -1;
        if(Math.abs(lheight-rheight)>1)
            return -1;
        return Math.max(lheight,rheight)+1;
    }
}

//Method 2 --> Top to Bottom

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
           return true;
        if(Math.abs(height(root.left)-height(root.right))>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return Math.max(lHeight,rHeight)+1;
    }
}
