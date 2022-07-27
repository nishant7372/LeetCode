//Breadth First Search
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for(int i=1;i<list.size();i+=2)
            Collections.reverse(list.get(i));
        return list;
    }
}

//Depth First Search
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        
        traverse(root,0,a);
        
        for(int i=0;i<a.size();i++)
        {
            if(i%2==1)
            Collections.reverse(a.get(i));
        }
        return a;
    }
    
    private void traverse(TreeNode root,int c, List<List<Integer>> a)
    {
        if(root==null)
            return;
        if(a.size()<=c)
             a.add(new ArrayList<Integer>());
        a.get(c).add(root.val);
        traverse(root.left,c+1,a);
        traverse(root.right,c+1,a);
    }
}
