//Breadth First Search
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        if(root!=null)
        q.add(root);
        int j=0;
        while(!q.isEmpty())
        {
            int c=q.size();
            list.add(new ArrayList<Integer>());
            for(int i=0;i<c;i++)
            {
                TreeNode presentNode = q.remove();
                list.get(j).add(presentNode.val);
                if(presentNode.left!=null)
                    q.add(presentNode.left);
                if(presentNode.right!=null)
                    q.add(presentNode.right);
            }
            j++;
        }
        Collections.reverse(list);
        return list;
    }
}

//Depth First Search
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> a = new ArrayList<List<Integer>>();
        int max = maxDepth(root);
        for(int i=0;i<=max;i++)
        a.add(new ArrayList<Integer>());
        traverse(root,0,a,max);
        return a;
    }
    
    private void traverse(TreeNode root,int c,List<List<Integer>> a,int max)
    {
        if(root==null)
        return;
        a.get(max-c).add(root.val);
        c++;
        traverse(root.left,c,a,max);
        traverse(root.right,c,a,max);
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
