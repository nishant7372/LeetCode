class Solution {
    boolean flag;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        flag=true;
        int count=0;
        for(int i=0;i<grid2.length;i++)
        {
            for(int j=0;j<grid2[0].length;j++)
            {
                if(grid2[i][j]==1)
                {
                    dfs(grid1,grid2,i,j);
                    if(flag)
                        count++;
                    flag=true;
                }
            }
        }
        return count;
    }
    
    
    private void dfs(int[][] grid1,int[][] grid2, int i,int j)
    {
        if(i==-1||j==-1||i==grid2.length||j==grid2[0].length||grid2[i][j]==0)
            return;
        if(grid1[i][j]!=1)
            flag=false;
        grid2[i][j]=0;
        dfs(grid1,grid2,i+1,j);
        dfs(grid1,grid2,i-1,j);
        dfs(grid1,grid2,i,j+1);
        dfs(grid1,grid2,i,j-1);
    }
}
