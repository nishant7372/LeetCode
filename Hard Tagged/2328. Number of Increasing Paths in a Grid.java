// Memoization -> DP

class Solution {
    static int mod = 1000000007;
    int m, n;
    public int countPaths(int[][] grid) {
        long ans=0;
        m=grid.length; n=grid[0].length;
        Integer[][] dp = new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=solve(grid,i,j,-1,dp)+1;
            }
        }

        return (int)(ans%mod);
    }

    private int solve(int[][] grid,int i,int j,int last,Integer[][] dp){
        //cannot be taken as a path
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]<=last) 
            return -1;
        
        if(dp[i][j]!=null)
          return dp[i][j];

        int up = solve(grid,i-1,j,grid[i][j],dp)+1;
        int down = solve(grid,i+1,j,grid[i][j],dp)+1;
        int left = solve(grid,i,j-1,grid[i][j],dp)+1;
        int right = solve(grid,i,j+1,grid[i][j],dp)+1;

        return dp[i][j] = (int)((up+down+left+right)%mod);
    }
}
