// 1ms runtime Beats 100% O(n*n) time & O(1) space

class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, area=0;
        
        for(int i=0;i<n;i++){
            int maxRow=0;
            int maxCol=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]>0)
                   area++;
                maxRow=Math.max(grid[i][j],maxRow);
                maxCol=Math.max(grid[j][i],maxCol);
            }
            area+=maxRow+maxCol;
        }
        return area;
    }
}
