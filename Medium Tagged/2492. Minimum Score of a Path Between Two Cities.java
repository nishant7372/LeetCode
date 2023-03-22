// Depth First Search

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] a = new ArrayList[n+1];
        
        for(int i=0;i<=n;i++) {
            a[i]=new ArrayList<int[]>();
        }
        for(int[] x:roads){
            a[x[0]].add(new int[]{x[1],x[2]});
            a[x[1]].add(new int[]{x[0],x[2]});
        }
    
        int[] vis = new int[n+1];
        return dfs(a,1,vis);
    }

    private int dfs(ArrayList<int[]>[] a,int curr,int[] vis){
        if(vis[curr]==1)
            return Integer.MAX_VALUE;
        vis[curr]=1;
        int min = Integer.MAX_VALUE;
        for(int[] x:a[curr]){    
            min = Math.min(min,Math.min(x[1],dfs(a,x[0],vis)));
        }
        return min;
    }
}

// Breadth First Search

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
        int[] vis = new int[n+1];
        while(!queue.isEmpty())
        {
            int curr = queue.remove();
            if(vis[curr]==1)
               continue;
            vis[curr]=1;
            for(int[] x:a[curr]){    
                queue.add(x[0]);
                min = Math.min(min,x[1]);
            }
        }
        return min;
    }
}
