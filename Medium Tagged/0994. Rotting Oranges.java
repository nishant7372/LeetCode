class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        int total = 0;
        int rotten = 0;
        int time=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]>=1)
                    total++;
                if(grid[i][j]==2)
                {
                    rotten++;
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(rotten==total)
            return 0;
        
        while(!queue.isEmpty() && rotten<total)
        {
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++)
            {
            int[] curr=queue.remove();
            
            if(curr[0]+1<grid.length && grid[curr[0]+1][curr[1]]==1)
            {
                queue.add(new int[]{curr[0]+1,curr[1]});
                grid[curr[0]+1][curr[1]]=2;
                rotten++;
            }
            if(curr[0]-1>-1 && grid[curr[0]-1][curr[1]]==1)
            {
                queue.add(new int[]{curr[0]-1,curr[1]});
                grid[curr[0]-1][curr[1]]=2;
                rotten++;
            }
            if(curr[1]+1<grid[0].length && grid[curr[0]][curr[1]+1]==1)
            {
                queue.add(new int[]{curr[0],curr[1]+1});
                grid[curr[0]][curr[1]+1]=2;
                rotten++;
            }
            if(curr[1]-1>-1 && grid[curr[0]][curr[1]-1]==1)
            {
                queue.add(new int[]{curr[0],curr[1]-1});
                grid[curr[0]][curr[1]-1]=2;
                rotten++;
            }
            }
        }
        if(rotten==total)
        return time;
        return -1;
    }
}
