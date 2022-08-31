class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1'){
                    removeIsland(grid,i,j);
                    count++;
                }    
            }
        }
        return count;
    }
    
    private void removeIsland(char[][] grid,int i,int j){
        if(i==-1||j==-1||i==grid.length||j==grid[i].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        removeIsland(grid,i-1,j);
        removeIsland(grid,i+1,j);
        removeIsland(grid,i,j-1);
        removeIsland(grid,i,j+1);    
    }
}

