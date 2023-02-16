// Method 1
// 1ms runtime Beats 99.65%
// Memoization -> Top Down Approach

class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return solve(dp,grid,grid.length-1,grid[0].length-1);
    }

    private int solve(Integer[][] dp,int[][] grid,int i,int j){
        if(i==-1 || j==-1)
           return Integer.MAX_VALUE;
        if(i==0 && j==0)
           return grid[i][j];
        if(dp[i][j]!=null)
           return dp[i][j];
        int sum1 = solve(dp,grid,i-1,j);
        int sum2 = solve(dp,grid,i,j-1);
        return dp[i][j]=grid[i][j] + Math.min(sum1,sum2);
    } 
}

// Method 2
// 2ms runtime Beats 80%
// Tabulation -> Bottom Up Approach

class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=1;i<grid.length;i++)
            grid[i][0]+=grid[i-1][0];
        
        for(int i=1;i<grid[0].length;i++)
            grid[0][i]+=grid[0][i-1];
        
        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
