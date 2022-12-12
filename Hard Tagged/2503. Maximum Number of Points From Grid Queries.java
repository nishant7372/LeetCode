class Solution {
    Map<Integer,Integer> map;
    public int[] maxPoints(int[][] grid, int[] queries) {
        map = new HashMap<>();
        int[] a = Arrays.copyOf(queries,queries.length);
        Arrays.sort(queries);
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        int[][] vis = new int[grid.length][grid[0].length];
        vis[0][0]=1;
        int i=0;
        for(int x:queries)
        {
            queue = bfs(grid,vis,x,queue,i,queries);
            i++;
        }
        
        for(int j=0;j<a.length;j++)
            a[j]=map.get(a[j]);
        
        return a;
    }
    
    
    private Queue<int[]> bfs(int[][] grid,int[][] vis,int x,Queue<int[]> queue,int idx,int[] queries)
    {
        Queue<int[]> queue2 = new ArrayDeque<>();
        int c=0;
        while(!queue.isEmpty())
        {
            int[] curr = queue.remove();
            int i = curr[0];
            int j = curr[1];
            if(grid[i][j]>=x){
                queue2.add(curr);
                continue;
            }
            if(i+1<grid.length && vis[i+1][j]==0)
            {
                vis[i+1][j]=1;
                queue.add(new int[]{i+1,j});
            }
            if(i-1>=0 && vis[i-1][j]==0)
            {
                vis[i-1][j]=1;
                queue.add(new int[]{i-1,j});
            }
            if(j+1<grid[0].length && vis[i][j+1]==0)
            {
                vis[i][j+1]=1;
                queue.add(new int[]{i,j+1});
            }
            if(j-1>=0 && vis[i][j-1]==0)
            {
                vis[i][j-1]=1;
                queue.add(new int[]{i,j-1});
            }  
            c++;
        }
        if(idx==0)
            map.put(x,c);
        else
            map.put(x,map.get(queries[idx-1])+c);
        return queue2;
    }
} 
