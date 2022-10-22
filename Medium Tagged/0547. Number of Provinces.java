class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c=0; //provinces count
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected.length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    dfs(isConnected,i,j);
                    c++; 
                }
            }
        }
        return c;  
    }
    
    private void dfs(int[][] a,int i,int j)
    {
        a[i][j]=a[j][i]=0;
        for(int x=0;x<a.length;x++)
        {
            if(a[i][x]!=0)
                dfs(a,i,x);
            if(a[x][j]!=0)
                dfs(a,x,j);
        }
    }
}
