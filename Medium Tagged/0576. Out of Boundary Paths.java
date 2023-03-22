// Memoization , Top down Apporoach Beats 100%

class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return solve(m,n,maxMove,startRow,startColumn,0,dp);
    }

    private int solve(int m,int n,int max,int i,int j,int c,Integer[][][] dp){
        if(c>max){
            return 0;
        }
        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        }
        if(dp[i][j][c]!=null){
            return dp[i][j][c];
        }
        int up = solve(m,n,max,i-1,j,c+1,dp);
        int down = solve(m,n,max,i+1,j,c+1,dp);
        int left = solve(m,n,max,i,j-1,c+1,dp);
        int right = solve(m,n,max,i,j+1,c+1,dp);

        return dp[i][j][c] = (int)(((long)up+down+left+right)%mod);
    }
}
