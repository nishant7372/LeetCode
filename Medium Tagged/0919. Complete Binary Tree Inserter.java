class CBTInserter {
    private TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode presentNode = queue.remove();
            if(presentNode.left==null)
            {
                presentNode.left = new TreeNode(val);
                return presentNode.val;
            }
            else if(presentNode.right==null)
            {
                presentNode.right = new TreeNode(val);
                return presentNode.val;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
        return 0;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
