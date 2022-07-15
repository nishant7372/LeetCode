class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
       
        for(int i=0;i<=maxDepth(root);i++)
        a.add(new ArrayList<Integer>());
        
        levelOrder(root,0,a);
        return a;
    }
    
    private void levelOrder(TreeNode root,int c, List<List<Integer>> a)
    {
        if(root==null)
            return;
        a.get(c).add(root.val);
        levelOrder(root.left,c+1,a);
        levelOrder(root.right,c+1,a);
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
