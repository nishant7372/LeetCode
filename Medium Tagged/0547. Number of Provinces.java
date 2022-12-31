//Method 1
//Optimized --> 1ms runtime Faster than 99.93%

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c=0; //provinces count
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
                if(!visited[i])
                {
                    dfs(isConnected,i,visited);
                    c++; 
                }
        }
        return c;  
    }
    
    private void dfs(int[][] a,int i,boolean[] visited)
    {
        visited[i]=true;
        for(int x=0;x<a.length;x++)
        {
            if(!visited[x] && a[i][x]==1){
                dfs(a,x,visited);
            }
        }
    }
}



//Method 2
// 12ms runtime Faster than 12.4%
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
