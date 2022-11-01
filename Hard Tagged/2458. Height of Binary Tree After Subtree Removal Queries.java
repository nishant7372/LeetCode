class Solution {
    int max;
    public int[] treeQueries(TreeNode root, int[] queries) {
        max=0;
        findMax(root);
        int[][] a = new int[max+1][2]; //hashtable to store height and level of each node
        
        ArrayList<PriorityQueue<Integer>> queue = new ArrayList<>();
        int height = height(root,a,0,queue);
        
        int i=0;
        int[] res = new int[queries.length];
        for(int query:queries)
        {
            res[i++]= height - getDiff(queue,a[query][0],a[query][1]);
        }
        return res;
    }
    
    
    private int height(TreeNode root,int[][] a,int level,ArrayList<PriorityQueue<Integer>> queue)  
	// storing height and level for each node in hashtable & heights at each level in priorityQueue
    {
        if(root==null)
            return -1;
        if(queue.size()==level)
        queue.add(new PriorityQueue<Integer>(Collections.reverseOrder()));
        
        int lheight=height(root.left,a,level+1,queue);
        int rheight=height(root.right,a,level+1,queue);
        int ans = Math.max(lheight,rheight)+1;
        
        queue.get(level).add(ans);
        a[root.val][0]=ans;
        a[root.val][1]=level;
        return ans;
    }
    
    private void findMax(TreeNode root)  // find hashtable size
    {
        if(root==null)
            return;
        if(root.val>max)
            max=root.val;
        findMax(root.left);
        findMax(root.right);
    }
    
    private int getDiff(ArrayList<PriorityQueue<Integer>> queue,int h,int l) //reduced height
    {
        PriorityQueue<Integer> pq = queue.get(l);
        int ans=0;
        if(pq.peek()==h)
        {
            int prev = pq.remove();
            if(!pq.isEmpty())
                ans = prev-pq.peek();
            else
                ans = prev+1;
            pq.add(prev);
        }
        return ans;
    }
}
