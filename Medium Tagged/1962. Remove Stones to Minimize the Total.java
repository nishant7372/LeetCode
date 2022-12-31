class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:piles)
            queue.add(x);
        
        while(k-->0)
        {
            int pile = queue.remove();
            pile-=Math.floor(pile/2);
            while(!queue.isEmpty()&&pile>queue.peek()&&k>0)
            {
                pile-=Math.floor(pile/2);
                k--;
            }
            queue.add(pile);
        }
        int stones=0;
        for(int x:queue)
            stones+=x;
        return stones;
    }
}
