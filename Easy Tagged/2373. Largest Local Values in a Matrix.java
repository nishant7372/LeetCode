class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length-2][grid.length-2];
        for(int i=0;i<grid.length-2;i++)
        {
            for(int j=0;j<grid.length-2;j++)
            {
                 res[i][j]=max(grid,i,i+3,j,j+3);
            }
        }
        return res;    
    }
    
    private int max(int[][] grid,int start,int end,int start2,int end2)
    {
        int max=0;
        for(int i=start;i<end;i++)
        {
            for(int j=start2;j<end2;j++)
            {
                if(max<grid[i][j])
                    max=grid[i][j];
            }
        }
        return max;
    }
}
