class Solution {
    boolean res=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
          inorder(subRoot,a);
          preOrder(subRoot,b);
          traverse(root,a,b);
              return res;
    }
    
    private void traverse(TreeNode root,ArrayList<Integer> a,ArrayList<Integer> b)
    {
        if(root==null)
            return;
        traverse(root.left,a,b);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        inorder(root,list);
        preOrder(root,list2);
        if(a.equals(list)&&b.equals(list2))
            res=true;
        traverse(root.right,a,b);
    }

    
    private void inorder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    
    private void preOrder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null)
            return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
