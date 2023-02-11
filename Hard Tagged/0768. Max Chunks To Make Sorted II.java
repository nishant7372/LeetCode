// Beats 100%, O(n) time and O(n) space

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        int m = Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            m = Math.min(m,arr[i]);
            min[i] = m;
        }
        
        int c=1, max=0;
        
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,arr[i]);
            if(max<=min[i+1])
                c++;
        }
        return c;
    }
}


// Beats 6% -> TreeMap Solution

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer,Integer> map = new TreeMap<>();

        for(int x:arr)
            map.put(x,map.getOrDefault(x,0)+1);
        
        int c=1,max=0;
        for(int x:arr){
            max=Math.max(max,x);
            map.put(x,map.get(x)-1);
            if(map.get(x)==0)
                map.remove(x);
            if(!map.isEmpty() && map.keySet().iterator().next()>=max)
                c++;
        }
        return c;
    }
}
