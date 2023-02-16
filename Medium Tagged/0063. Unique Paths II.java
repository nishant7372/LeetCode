// 0ms runtime Beats 100% 
// Method 1 -> Tabulation (Bottom Up Approach)

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp= new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0]==1? 0:1;
        for(int i=1;i<dp.length;i++){
            dp[i][0] = grid[i][0]==1? 0:dp[i-1][0]; //dp state equation for 1st col
        }
           
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]= grid[0][j]==1? 0:dp[0][j-1];   //dp state equation for 1st row
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = grid[i][j]==1? 0: dp[i-1][j]+dp[i][j-1]; //dp state equation
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}

// 0ms runtime Beats 100% 
// Method 2 -> Memoization (Top Down Approach)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        // Method 2 -> Memoization (Top Down Approach)
        Integer[][] dp= new Integer[grid.length][grid[0].length];
        dp[0][0] = grid[0][0]==1? 0:1;
        return solve(dp,grid,grid.length-1,grid[0].length-1);
    }

    private int solve(Integer[][] dp,int[][] grid,int i,int j){
        if(i==-1 || j==-1 || grid[i][j]==1)
           return 0;
        if(dp[i][j]!=null)
            return dp[i][j];
        int res1 = solve(dp,grid,i-1,j);
        int res2 = solve(dp,grid,i,j-1);
        return dp[i][j] = res1+res2;
    }
}
