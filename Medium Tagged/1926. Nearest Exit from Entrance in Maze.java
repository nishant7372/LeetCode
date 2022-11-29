class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze,entrance[0],entrance[1]);
    }
    
    
    private int bfs(char[][] maze,int i,int j)
    {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{i,j});
        int c=0;
        while(!queue.isEmpty())
        {
            int len = queue.size();
            
            while(len-->0)
            {
                int[] curr = queue.remove();
            
                i=curr[0];
                j=curr[1];
                maze[i][j]='+';
                if(i==0||j==0||i==maze.length-1||j==maze[0].length-1)
                {
                    if(c!=0)
                        return c;
                }
                func(i+1,j,maze,queue);
                func(i-1,j,maze,queue);
                func(i,j+1,maze,queue);
                func(i,j-1,maze,queue);
            }
            c++;
        }
        return -1;
    }


private void func(int i,int j,char[][] maze,Queue<int[]> queue)
{
    if(i<maze.length && i>=0 && j<maze[0].length && j>=0 && maze[i][j]!='+'){
        queue.add(new int[]{i,j});
        maze[i][j]='+';
    }
}
}
