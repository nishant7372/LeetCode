// Method 1 -> 0ms runtime Beats 100%
// BackTracking

class Solution {
    int paths;
    public int uniquePathsIII(int[][] grid) {
        paths=0;
        int x=0,y=0,c=1;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                   x=i;
                   y=j;
                }
                if(grid[i][j]==0)
                    c++;
            }
        }
        solve(x,y,grid,c);
        return paths;
    }

    private void solve(int i,int j,int[][] grid,int c)
    {
        if(i==-1||j==-1||i==grid.length||j==grid[0].length||grid[i][j]==-1)
            return;
        if(grid[i][j]==2){
            if(c==0)
               paths++;
            return;
        }
        grid[i][j]=-1;
        solve(i+1,j,grid,c-1);
        solve(i-1,j,grid,c-1);
        solve(i,j-1,grid,c-1);
        solve(i,j+1,grid,c-1);
        grid[i][j]=0;
    }
}
