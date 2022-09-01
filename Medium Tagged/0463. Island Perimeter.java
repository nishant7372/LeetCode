class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                    return dfs(grid,i,j,0);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int[][] grid,int i,int j,int p)
    {
        if(i==-1||j==-1||i==grid.length||j==grid[0].length||grid[i][j]==0)
        {
            return ++p;
        }
        if(grid[i][j]==-1){
            return p;
        }
        grid[i][j]=-1;  //marking as visited
        return dfs(grid,i+1,j,p) + dfs(grid,i,j+1,p) + dfs(grid,i-1,j,p) + dfs(grid,i,j-1,p);
    }
}
