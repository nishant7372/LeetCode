//Method 1 -> 0ms runtime Beats 100%
//Time Complexity -> O(n) and Space Complexity -> O(101)

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        
        for(int x:nums)
            freq[x]++;
        
        int sum=0;
        for(int i=1;i<freq.length;i++)
            freq[i]+=freq[i-1];
        
        int i=0;
        for(int x:nums)
            nums[i++] = x==0? 0:freq[x-1];

        return nums;
    }
}

// Method 2 -> 9ms runtime Beats 71%
// Using TreeMap

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new TreeMap();
        
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        
        Map<Integer,Integer> map2 = new HashMap();
        
        int sum=0;
        for(var entry:map.entrySet()){
            map2.put(entry.getKey(),sum);
            sum+=entry.getValue();
        }
        
        int i=0;
        for(int x:nums){
            nums[i++] = map2.get(x);
        }
        return nums;
    }
}
