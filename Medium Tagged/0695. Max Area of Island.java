class Solution {
    private int area;
    public int maxAreaOfIsland(int[][] grid) {
        area=0;
        int maxArea=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    calcArea(grid,i,j);
                    if(maxArea<area)
                        maxArea=area;
                    area=0;
                }
            }
            
        }
        return maxArea;
    }
    
    
    private void calcArea(int[][] grid,int i,int j)
    {
        if(i==-1||i==grid.length||j==-1||j==grid[0].length||grid[i][j]==0)
            return;
        grid[i][j]=0;
        area++;
        calcArea(grid,i+1,j);
        calcArea(grid,i,j+1);
        calcArea(grid,i-1,j);
        calcArea(grid,i,j-1);
    }
}
