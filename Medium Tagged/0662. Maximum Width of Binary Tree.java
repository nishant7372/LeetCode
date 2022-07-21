class Solution {
    public int widthOfBinaryTree(TreeNode root) {
    List<List<Integer>> a = new ArrayList<List<Integer>>();
        int max=maxDepth(root);
        int[] b= new int[max];
        for(int i=0;i<max;i++)
        a.add(new ArrayList<Integer>());
        
        traverse(root,0,a,b);
        max=0;
        for(int i=0;i<a.size();i++)
        {
            max=Math.max(find(a.get(i)),max);
        }
        return max;
    }
    
    private int find(List<Integer> a)
    {
        return a.get(a.size()-1)-a.get(0)+1;
    }
    
    private void traverse(TreeNode root,int c,List<List<Integer>> a,int[] b)
    {
        if(root==null)
        {
             func(a,c,b);
             return;
        }
        a.get(c).add(b[c]++);
        traverse(root.left,c+1,a,b);
        traverse(root.right,c+1,a,b);
    }
    
    private int maxDepth(TreeNode root)
    {
        if(root==null)
           return 0; 
        
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth,rDepth)+1;
    }
    
    private void func(List<List<Integer>> a,int c,int[] b)
    {
        int k=0;
        while(c!=a.size())
        {
            b[c]+=(int)Math.pow(2,k);
            c++;
            k++;
        } 
    }
}
