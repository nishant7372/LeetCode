class Solution {
    List<List<Integer>> a;
    public TreeNode reverseOddLevels(TreeNode root) {
        a = new ArrayList<>();
        get(root,0);
        put(root,0);
        return root;
    }
    
    private void get(TreeNode root,int c)
    {
        if(root==null)
            return;
        if(a.size()==c)
            a.add(new ArrayList<Integer>());
        if(c%2==1)
            a.get(c).add(root.val);
        get(root.left,c+1);
        get(root.right,c+1);
    }
    
    private void put(TreeNode root,int c)
    {
        if(root==null)
            return;
        if(c%2==1)
            root.val = a.get(c).remove(a.get(c).size()-1); 
        put(root.left,c+1);
        put(root.right,c+1);
    }
}
