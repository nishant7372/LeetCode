//Breadth First Search
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty())
        {
            int c=q.size();
            long sum=0;
            for(int i=0;i<c;i++)
            {
                TreeNode presentNode = q.remove();
                sum+=presentNode.val;
                if(presentNode.left!=null)
                   q.add(presentNode.left);
                if(presentNode.right!=null)
                   q.add(presentNode.right);
            }
            res.add((double)sum/c);
        }
        return res;
    }
}

//Depth First Search
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
    List<Double> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
        traverse(root,0,a,b);
        for(int i=0;i<a.size();i++)
            a.set(i,a.get(i)/b.get(i));
        return a;
    }

    private void traverse(TreeNode root,int c,List<Double> a,List<Integer> b)
    {
        if(root==null)
             return;
        if(a.size()<=c)
        {
            a.add(new Double(0.00));
            b.add(new Integer(0));
        }
        a.set(c,a.get(c)+root.val);
        b.set(c,b.get(c)+1);
        traverse(root.left,c+1,a,b);
        traverse(root.right,c+1,a,b);
    }
}
