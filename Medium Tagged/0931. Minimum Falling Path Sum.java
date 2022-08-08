class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(j==0)
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==matrix.length-1)
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],Math.min(matrix[i-1][j+1],matrix[i-1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int x:matrix[matrix.length-1])
            if(min>x)
                min=x;
        return min;
    }
}
