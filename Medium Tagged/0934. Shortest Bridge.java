// ## Intuition
// 1. Use DFS for traversal of 1st island.(same can be done using BFS)
// 2. Use BFS for finding smallest path to the 2nd island.

// ## Approach
// * Traverse the 1st island found using dfs.
// * While doing dfs add all the water boundaries(i,j)`grid[i][j]=0` of 1st island in the queue.
// * Using multi-source bfs, find the smallest path to the 2nd island.

    
class Solution {
    boolean[][] visited;
    int n;
    public int shortestBridge(int[][] grid) {
        n=grid.length;
        visited=new boolean[n][n];

        boolean flag=false;
        Queue<int[]> queue = new ArrayDeque<>(); //for adding boundaries of 1st island

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,queue);  //traverse the 1st island found
                    flag=true;
                    break;
                }  
            }
            if(flag)
               break;
        }
        
        return bfs(grid,queue);  //return smallest number of flipped 0's
    }
    
    private int bfs(int[][] grid,Queue<int[]> queue)
    {
        int level=0;
        while(!queue.isEmpty())
        {
            int len = queue.size();
            
            while(len-->0)
            {
                int[] curr = queue.remove();
                int i=curr[0], j=curr[1];
                if(grid[i][j]==1)
                   return level;

                if(i+1<n && !visited[i+1][j]){
                   queue.add(new int[]{i+1,j});
                   visited[i+1][j]=true;
                }

                if(i-1>=0 && !visited[i-1][j]){
                   queue.add(new int[]{i-1,j});
                   visited[i-1][j]=true;
                }
                
                if(j+1<n && !visited[i][j+1]){
                   queue.add(new int[]{i,j+1});
                   visited[i][j+1]=true;
                }
                
                if(j-1>=0 && !visited[i][j-1]){
                   queue.add(new int[]{i,j-1});
                   visited[i][j-1]=true;
                }
            }
            level++;
        }
        return level;
    }


    private void dfs(int i,int j,int[][] grid,Queue<int[]> queue)
    {
        if(i==-1||i==n||j==-1||j==n||visited[i][j])
            return;
        visited[i][j]=true;
        if(grid[i][j]==0)
        {
            queue.add(new int[]{i,j});
            return;
        }
        dfs(i+1,j,grid,queue);
        dfs(i,j+1,grid,queue);
        dfs(i-1,j,grid,queue);
        dfs(i,j-1,grid,queue);
    }
}
