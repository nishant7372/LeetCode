class Solution {
    int[][] pacific,atlantic;
    int n,m;
    List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        res = new ArrayList<List<Integer>>();
        pacific = new int[n][m];   //cells visited from pacific bounaries
        atlantic = new int[n][m];  //cells visited from atlantic bounaries
        
        //Left and Right Boundaries of Rectangular Island
        for(int i=0;i<n;i++)  
        {
            dfs(heights,i,0,pacific);      //cells connected to pacific boundaries
            dfs(heights,i,m-1,atlantic);   //cells connected to atlantic boundaries
        }
        
        //Top and Bottom Boundaries of Rectangular Island
        for(int j=0;j<m;j++)
        {
            dfs(heights,0,j,pacific);      //cells connected to pacific boundaries
            dfs(heights,n-1,j,atlantic);   //cells connected to atlantic boundaries
        }
        
        return res;
    }
    
    /* visited is a reference of atlantic and pacific matrices*/
    private void dfs(int[][] heights,int i,int j,int[][] visited)
    {
       if(visited[i][j]==1)          //if cell is already visited
           return;
       visited[i][j]=1;              //mark the cell as visited
       
       //if cell can be reached from both pacific and atlantic boundaries
       if(atlantic[i][j]==1&&pacific[i][j]==1)        
          res.add(new ArrayList<>(Arrays.asList(i,j)));
       
       /*visiting the adjacent cells only when their height is greter than or equal to curr cells
        so that water can flow from adjacent to curr cells*/
        
       if(i+1<n&&heights[i][j]<=heights[i+1][j])
            dfs(heights,i+1,j,visited);
        
       if(j+1<m&&heights[i][j]<=heights[i][j+1])
            dfs(heights,i,j+1,visited);
        
       if(i-1>=0&&heights[i][j]<=heights[i-1][j])
            dfs(heights,i-1,j,visited);
        
       if(j-1>=0&&heights[i][j]<=heights[i][j-1])
            dfs(heights,i,j-1,visited);
      }
}
BFS solution

class Solution {
    int[][] pacific,atlantic;
    int n,m;
    List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        res = new ArrayList<List<Integer>>();
        pacific = new int[n][m];   //cells visited from pacific bounaries
        atlantic = new int[n][m];  //cells visited from atlantic bounaries
        
        //Left and Right of Rectangular Island
        for(int i=0;i<n;i++)  
        {
            bfs(heights,i,0,pacific);      //cells connected to pacific boundaries
            bfs(heights,i,m-1,atlantic);   //cells connected to atlantic boundaries
        }
        
        //Above and Below of Rectangular Island
        for(int j=0;j<m;j++)
        {
            bfs(heights,0,j,pacific);      //cells connected to pacific boundaries
            bfs(heights,n-1,j,atlantic);   //cells connected to atlantic boundaries
        }
        
        return res;
    }
    
    /* visited is a reference of atlantic and pacific matrices*/
    private void bfs(int[][] heights,int i,int j,int[][] visited)
    {
       Queue<int[]> queue = new ArrayDeque<>();
       queue.add(new int[]{i,j}); 
       while(!queue.isEmpty())
       {
           int[] curr = queue.remove();
           i = curr[0];
           j = curr[1]; 
           if(visited[i][j]==1)          //if cell is already visited
               continue;
           visited[i][j]=1;              //mark the cell as visited
       
           //if cell can be reached from both pacific and atlantic boundaries
           if(atlantic[i][j]==1&&pacific[i][j]==1)        
               res.add(new ArrayList<>(Arrays.asList(i,j)));  
       
           /*visiting the adjacent cells only when their height is greter than or equal 
           to curr cells so that water can flow from adjacent to curr cells*/
        
           if(i+1<n&&heights[i][j]<=heights[i+1][j])
               queue.add(new int[]{i+1,j});
        
           if(j+1<m&&heights[i][j]<=heights[i][j+1])
               queue.add(new int[]{i,j+1});
        
           if(i-1>=0&&heights[i][j]<=heights[i-1][j])
               queue.add(new int[]{i-1,j});
        
           if(j-1>=0&&heights[i][j]<=heights[i][j-1])
               queue.add(new int[]{i,j-1});
      }
    }
}
