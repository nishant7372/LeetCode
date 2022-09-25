class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int bUsed = 0;
        for(int i=0;i<heights.length-1;i++)
        {
            int currHeight = heights[i+1]-heights[i];
            if(currHeight>0)
            {
                if(queue.size()<ladders)
                    queue.add(currHeight);
                else
                {
                    if(ladders!=0 && currHeight>queue.peek())
                    {
                       bUsed+=queue.remove();
                       queue.add(currHeight);
                    }
                    else
                       bUsed+=currHeight; 
                    if(bUsed>bricks)
                          return i;
                }
            }
        }
        return heights.length-1;
    }
}
