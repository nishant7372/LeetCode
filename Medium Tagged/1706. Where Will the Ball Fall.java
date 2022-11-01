class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++)
        {
            res[j]=solve(grid,j);
        }
        return res;
    }
    
    
    private int solve(int[][] grid,int j)
    {
        for(int i=0;i<grid.length;i++)
        {
            if(j<grid[0].length-1 && grid[i][j]==1 && grid[i][j+1]==1){
                j++;
            } 
            else if(j>0 && grid[i][j]==-1 && grid[i][j-1]==-1){
                j--;
            }
            else
                return -1;
        }
        return j;
    }
}
