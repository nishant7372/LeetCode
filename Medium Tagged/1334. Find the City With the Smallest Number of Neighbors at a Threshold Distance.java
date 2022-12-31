class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] a = new int[n][n];
        for(int[] temp:a)
        {
            Arrays.fill(temp,100000000);
        }
        for(int[] x:edges)
        {
            a[x[0]][x[1]] = x[2];
            a[x[1]][x[0]] = x[2];
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]>a[i][k]+a[k][j])
                    a[i][j] = a[i][k] + a[k][j];
                }
            }
        }

            int minCity  = -1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                int c=0;
                for(int j=0;j<n;j++)
                {
                    if(i!=j && a[i][j]<=distanceThreshold)
                    c++;
                }
                
                if(c<=min)
                {
                    min=c;
                    minCity = i;
                }
            }
            return minCity;
    }
}
