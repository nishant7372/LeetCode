class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Map<Integer,Integer> map = new TreeMap<>();  //For Sorting and removing duplicates
        for(int[] a:items)
        {
            if(map.get(a[0])==null)
                map.put(a[0],a[1]);
            else if(map.get(a[0])<a[1])
                map.put(a[0],a[1]);
        }
        
        Map<Integer,Integer> map2 = new HashMap<>();  //For storing beautiful items for keySet
        int max=0;
        
        for(var entry:map.entrySet())
        {
            if(entry.getValue()>max)
            {
                map2.put(entry.getKey(),entry.getValue());
                max=entry.getValue();
            }
            else
                map2.put(entry.getKey(),max);
        }
        
        int i=0;
        int[] res = new int[queries.length];
     ArrayList<Integer> list = new ArrayList<>(map.keySet()); //Sorted KeySet for applying Binary Search
        for(int x:queries)
        {
            int index=0;
            if(map2.get(x)==null)
            {
                index = Collections.binarySearch(list,x)*-1-2;
                res[i++] = index<0? 0:map2.get(list.get(index)); 
            }
            else
                res[i++]=map2.get(x);
        }
        return res;
    }
}
