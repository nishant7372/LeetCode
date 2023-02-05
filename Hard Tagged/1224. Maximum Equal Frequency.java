// Both Implementations are same

// Using HashTable (5ms runtime Beats 92.3%)

class Solution {
    public int maxEqualFreq(int[] nums) {
        int max=0;
        for(int x:nums)
            if(x>max)
                max=x;
        int[] map = new int[100001];
        int[] a = new int[max+1];
        max=1;
        int maxFreq=0, minFreq=Integer.MAX_VALUE, count=0;
        for(int i=0;i<nums.length;i++){
            int freq =  ++a[nums[i]];
            if(map[freq]++==0){ // adding curr Freq
                count++;
            }
            if(freq>1 && map[freq-1]--==1){ // remove prev freq
                count--;
                if(freq-1==minFreq)
                minFreq++;
            }

            if(freq>maxFreq)
                maxFreq=freq;
            if(freq<minFreq)
                minFreq=freq;
    
            if(count==1 && (maxFreq==1 || map[maxFreq]==1)){
                max=Math.max(max,i+1);
            }
            
            if(count==2){
                if(map[1]==1 || (map[maxFreq]==1 && maxFreq==minFreq+1))
                   max=Math.max(max,i+1);
            }
        }
        return max;
    }
}

// Using HashMap (65ms runtime Beats 28.3%)

class Solution {
    public int maxEqualFreq(int[] nums) {
        int max=0;
        for(int x:nums)
            if(x>max)
                max=x;
        Map<Integer,Integer> map= new HashMap<>();
        int[] a = new int[max+1];
        max=1;
        for(int i=0;i<nums.length;i++){
            int freq =  ++a[nums[i]];
            map.put(freq,map.getOrDefault(freq,0)+1); // adding curr Freq
            if(a[nums[i]]!=1){
                map.put(freq-1,map.getOrDefault(freq-1,0)-1); // remove prev freq
                if(map.get(freq-1)==0){
                   map.remove(freq-1);
                }
            }
            if(map.keySet().size()==1){
                for(var e:map.entrySet()){
                    if(e.getKey()==1 || e.getValue()==1)
                       max=Math.max(max,i+1);
                }
            }
            if(map.keySet().size()==2){
                int maxFreq=0, minFreq=Integer.MAX_VALUE;
                for(var e:map.entrySet()){
                    if(e.getKey()==1 && e.getValue()==1)
                       max=Math.max(max,i+1);
                    if(e.getKey()>maxFreq)
                       maxFreq=e.getKey();
                    if(e.getKey()<minFreq)
                       minFreq=e.getKey();
                }
                if(map.get(maxFreq)==1 && maxFreq==minFreq+1)
                    max=Math.max(max,i+1);
            }
        }
        return max;
    }
}
