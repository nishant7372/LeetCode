class Solution {
    int maxR=0;
    int maxC=0;
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list= new ArrayList<>();
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[0].length;j++)
            {
                if(land[i][j]==1)
                {
                    dfs(land,i,j);
                    list.add(new int[]{i,j,maxR,maxC});
                    maxR=0;
                    maxC=0;
                }
            }
        }
        int i=0;
        int[][] res = new int[list.size()][4];
        for(int[] x:list)
        {
            res[i++]=x;
        }
        return res;
    }
    
    private void dfs(int[][] land,int i,int j)
    {
        if(i<0||j<0||i==land.length||j==land[i].length||land[i][j]==0)
            return;
        land[i][j]=0;
        if(i>maxR)
            maxR=i;
        if(j>maxC)
            maxC=j; 
        dfs(land,i+1,j);
        dfs(land,i-1,j);
        dfs(land,i,j+1);
        dfs(land,i,j-1);
    }
}
