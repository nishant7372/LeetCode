class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        for(int[] row: dist)
            Arrays.fill(row,Integer.MAX_VALUE-100000);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    dist[i][j]=0;
                else
                {
                    if(i>0)
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i-1][j]+1);
                    }
                    if(j>0)
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][j-1]+1);
                    }
                }
            }
        }
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i<m-1)
                {
                    dist[i][j]=Math.min(dist[i][j],dist[i+1][j]+1);
                }
                if(j<n-1)
                {
                    dist[i][j]=Math.min(dist[i][j],dist[i][j+1]+1);
                }
            }
        }
        return dist;
    }
}
