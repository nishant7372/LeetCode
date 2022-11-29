class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[][] a = new int[grid.length][2];
        int[][] b = new int[grid[0].length][2];
        
        for(int i=0;i<grid.length;i++)
        {
            int c=0;
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                    c++;
            }
            a[i][0]=c;
            a[i][1]=grid[i].length-c;
        }
    
        for(int i=0;i<grid[0].length;i++)
        {
            int c=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[j][i]==1)
                    c++;
            }
            b[i][0]=c;
            b[i][1]=grid.length-c;
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                grid[i][j] = a[i][0] + b[j][0] - a[i][1] - b[j][1];
            }
        }
        return grid;
    }
}
