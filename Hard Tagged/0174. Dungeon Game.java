// Method 1
// 1ms runtime Beats 94.5%
// Memoization -> Top-Down Approach

class Solution {
    int m, n;
    public int calculateMinimumHP(int[][] dungeon){
        m = dungeon.length;
        n = dungeon[0].length;
        Integer[][] dp = new Integer[m][n];
        return solve(dp,dungeon,0,0);
    }

    private int solve(Integer[][] dp,int[][] dungeon,int i,int j){
        if(i==m || j==n)
            return 100000000;
        if(dp[i][j]!=null)
            return dp[i][j];
        if(i==m-1 && j==n-1){
            return Math.max(1,1-dungeon[i][j]);
        }
        int down = Math.max(solve(dp,dungeon,i+1,j)-dungeon[i][j],1);
        int right = Math.max(solve(dp,dungeon,i,j+1)-dungeon[i][j],1);
        return dp[i][j]=Math.min(down,right);
    } 
}

// Method 2
// 2ms runtime, Beats 64% 
// Tabulation -> Bottom-Up Approach

class Solution {
    public int calculateMinimumHP(int[][] dungeon){
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        
        dp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1],1);

        // filling last col
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = Math.max(dp[i+1][n-1]-dungeon[i][n-1],1);
        }

        // filling last row
        for(int j=n-2;j>=0;j--){
            dp[m-1][j] = Math.max(dp[m-1][j+1]-dungeon[m-1][j],1);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int down = Math.max(dp[i+1][j]-dungeon[i][j],1);
                int right = Math.max(dp[i][j+1]-dungeon[i][j],1);
                dp[i][j] = Math.min(down,right);
            }
        }
        return dp[0][0];
    }
}
