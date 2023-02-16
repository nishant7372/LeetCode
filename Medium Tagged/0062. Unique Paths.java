// 0ms runtime Beats 100%
// Method 1 -> Tabulation --> Bottom Up Approach

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=0;i<n;i++)
            dp[0][i]=1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j]=dp[i][j-1]+dp[i-1][j]; //dp state equation
            }
        }
        return dp[m-1][n-1];
    }
}

// 0ms runtime Beats 100%
// Method 2 -> Memoization --> Top Down Appoach
class Solution {
    public int uniquePaths(int m, int n) {  
        int[][] dp = new int[m][n];
        return solve(dp,m-1,n-1);
    }

    private int solve(int[][] dp,int i,int j){
        if(i==0 || j==0){
            return 1;
        }
        if(dp[i][j]!=0)
           return dp[i][j];
        return dp[i][j]=solve(dp,i-1,j)+solve(dp,i,j-1);
    }
}
