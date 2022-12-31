//Method 3 --> Using TreeMap
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<capacity.length;i++){
            int x=capacity[i]-rocks[i];
            if(x<=additionalRocks)
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        List<Integer> list = new ArrayList<Integer>();

        int c=0;
        for(var entry:map.entrySet())
        {
            int val = entry.getKey();
            int count = entry.getValue();

            while(count-->0)
            {
                additionalRocks-=val;
                if(additionalRocks<0)
                   return c;
                c++;
            }
        }
        return c;
    }
}
