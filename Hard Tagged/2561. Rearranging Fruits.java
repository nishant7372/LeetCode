class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int x:basket1){
            map.put(x,map.getOrDefault(x,0)+1);
            min=Math.min(min,x);
        }

        for(int x:basket2){
            map.put(x,map.getOrDefault(x,0)-1);
            min=Math.min(min,x);
        }

        List<Integer> list = new ArrayList<>();
        for(var e:map.entrySet()){
            if(e.getValue()%2!=0)
                return -1;
            else{
                int freq = Math.abs(e.getValue())/2;
                while(freq-->0)
                list.add(e.getKey());
            }
        }
        Collections.sort(list);
        long cost=0;
        for(int i=0;i<list.size()/2;i++)
           cost+=Math.min(2*min,list.get(i));
        
        return cost;
    }
    
}
