class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] a = new ArrayList[n+1];
    
        for(int i=0;i<=n;i++)
        {
            a[i]=new ArrayList<int[]>();
        }
        for(int[] x:roads)
        {
            a[x[0]].add(new int[]{x[1],x[2]});
            a[x[1]].add(new int[]{x[0],x[2]});
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(1);
        
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int[] vis = new int[n+1];
        while(!queue.isEmpty())
        {
            int curr = queue.remove();
            if(curr==n)
                ans = Math.min(min,ans);
            if(vis[curr]==1)
               continue;
            vis[curr]=1;
            for(int[] x:a[curr])
            {
                if(x[1]!=0)
                {
                    queue.add(x[0]);
                    min = Math.min(min,x[1]);
                }
            }
        }
        return ans;
    }
}
