//Depth First Search -> 0ms runtime, Beats 100%

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list= new ArrayList<>();
        traverse(root,0,list);
        for(int i=1;i<list.size();i+=2)
            Collections.reverse(list.get(i));
        return list;
    }

    private void traverse(TreeNode root,int c,List<List<Integer>> a)
    {
        if(root==null)
            return;
        if(a.size()==c)
            a.add(new ArrayList<Integer>());
        a.get(c++).add(root.val);
        traverse(root.left,c,a);
        traverse(root.right,c,a);
    }
}

//Breadth First Search -> 1ms runtime, Beats 82%

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        if(root!=null)
        q.add(root);
        int j=0;
        while(!q.isEmpty())
        {
            int c=q.size();
            list.add(new ArrayList<Integer>());
            while(c-->0)
            {
                TreeNode curr = q.remove();
                list.get(j).add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            j++;
        }
        for(int i=1;i<list.size();i+=2)
            Collections.reverse(list.get(i));
        return list;
    }
}
