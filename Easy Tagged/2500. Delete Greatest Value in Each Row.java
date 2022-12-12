class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int[] x:grid)
        {
            Arrays.sort(x);
        }
        
        int ans=0;
        for(int j=0;j<grid[0].length;j++)
        {
            int max=0;
            for(int i=0;i<grid.length;i++)
            {
                max = Math.max(grid[i][j],max);
            }
            ans+=max;
        }
        return ans;
    }
}
