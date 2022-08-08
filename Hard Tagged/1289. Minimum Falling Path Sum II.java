class Solution {
    public int minFallingPathSum(int[][] grid) {
        for(int i=1;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
                grid[i][j]+=min(grid[i-1],j);
        }
        int min = Integer.MAX_VALUE;
        return min(grid[grid.length-1],-1);
    }
    
    private int min(int[] arr,int j)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(i==j)
                continue;
            if(min>arr[i])
                min=arr[i];
        }
        return min;
    }
}
