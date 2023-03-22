// Memoization -> DP, 9ms runtime Beats 77%

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
            {
                max= Math.max(max,solve(matrix,i,j,-1,dp));
            }
        }

        return max;
    }

    private int solve(int[][] matrix,int i,int j,int last,Integer[][] dp){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=last){
            return 0;
        }
        if(dp[i][j]!=null)
          return dp[i][j];
        int a = solve(matrix,i+1,j,matrix[i][j],dp);
        int b = solve(matrix,i-1,j,matrix[i][j],dp);
        int c = solve(matrix,i,j+1,matrix[i][j],dp);
        int d = solve(matrix,i,j-1,matrix[i][j],dp);

        return dp[i][j] = Math.max(Math.max(a,b),Math.max(c,d)) + 1;
    }
}
