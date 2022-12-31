//Method 1 --> Sorting

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<capacity.length;i++)
            a.add(capacity[i]-rocks[i]);
        
        Collections.sort(a);
        int c=0;

        for(int i=0;i<a.size();i++)
        {
            additionalRocks-=a.get(i);
            if(additionalRocks<0)
              break;
             c++;
        }
        return c;
    }
}

//Method 2 --> Priority Queue (Min-Heap)

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<capacity.length;i++){
            int x = capacity[i]-rocks[i];
            if(x<=additionalRocks)
            pq.add(x);
        }
        
        int c=0; //no. of full bags

        while(!pq.isEmpty())
        {
            additionalRocks-=pq.remove();
            if(additionalRocks<0)
              return c;
            c++;
        }
        return c;
    }
}

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
