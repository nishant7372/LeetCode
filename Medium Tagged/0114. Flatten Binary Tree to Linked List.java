class Solution {
    private List<TreeNode> list= new ArrayList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        TreeNode temp=root;
        for(int i=1;i<list.size();i++)
        {
            temp.left=null;
            temp.right=list.get(i);
            temp=temp.right;   
        }
    }
    
    private void preOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
