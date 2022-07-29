class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++)
        {
            if(map.get(cards[i])!=null)
                min=Math.min(min,i-map.get(cards[i])+1);
            map.put(cards[i],i);
        }
        return min==Integer.MAX_VALUE? -1: min;
    }
}
