/*The Approach is to remove all the land cells which can be reached from the boundaries.
Then counting all the remaining land cells after performing the above operation.*/

class Solution {
    int n,m;
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
		
		//performing dfs for all the cells which are reachable from the boundaries
		
		//for left and right boundaries
        for(int i=0;i<n;i++)
        {
            dfs(grid,i,0);
            dfs(grid,i,m-1);
        }
		
		//for top and bottom boundaries
        for(int j=0;j<m;j++)
        {
            dfs(grid,0,j);
            dfs(grid,n-1,j);
        }
		
		//counting all the remaining land cells
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(grid[i][j]==1)   //counting remaining land cells after removing the land cells reachable from the boundaries.
                    ans++;
            }
        }
        return ans;
    }
    
    
    private void dfs(int[][] grid,int i,int j)
    {
        if(i==-1||j==-1||i==n||j==m||grid[i][j]==0)
            return;
        grid[i][j]=0;   //removing all the land cells which can be reached from the boundaries.
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
