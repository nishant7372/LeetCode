class Solution {
    int paths;
    int empty;
    public int uniquePathsIII(int[][] grid) {
        empty = countEmpty(grid);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                solve(i,j,grid,0);
                return paths;
                }
            }
        }
        return 0;
    }

    private void solve(int i,int j,int[][] grid,int c)
    {
        if(i==-1||j==-1||i==grid.length||j==grid[0].length||grid[i][j]==-1)
        return;
        if(grid[i][j]==2 && c==empty+1){
            paths++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j]=-1;
        solve(i+1,j,grid,c+1);
        solve(i-1,j,grid,c+1);
        solve(i,j-1,grid,c+1);
        solve(i,j+1,grid,c+1);
        grid[i][j]= temp;
    }


    private int countEmpty(int[][] grid)
    {
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0){
                    c++;
                }
            }
        }
        return c;
    }
}
