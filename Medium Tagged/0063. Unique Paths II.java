class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp= new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==1)
            dp[0][0]=0;
        else
            dp[0][0]=1;
        for(int i=1;i<dp.length;i++)
        {
            if(obstacleGrid[i][0]==1)
                    dp[i][0]=0;
            else
                 dp[i][0]=dp[i-1][0];   //dp state equation for 1st row
        }
           
        for(int i=1;i<dp[0].length;i++)
        {
            if(obstacleGrid[0][i]==1)
                    dp[0][i]=0;
            else
                 dp[0][i]=dp[0][i-1];   //dp state equation for 1st col
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];  //dp state equation
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
