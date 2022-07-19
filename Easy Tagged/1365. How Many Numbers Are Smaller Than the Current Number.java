//Method 1
//Time Complexity -> O(n) and Space Complexity -> O(101)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        
        for(int x:nums)
        {
            freq[x]++;
        }
        
        int sum=0;
        for(int i=0;i<freq.length;i++)
        {
            int a = freq[i];
            freq[i]=sum;
            sum+=a;
        }
        
        int i=0;
        for(int x:nums)
        {
            nums[i++] = freq[x];
        }
        return nums;
    }
}

//Method 2
//Using TreeMap and HashMap
// 9ms runtime faster than 71 percent
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer,Integer> map = new TreeMap();
        
        for(int x:nums)
        {
            if(map.get(x)==null)
                map.put(x,1);
            else
                map.put(x,map.get(x)+1);
        }
        
        Map<Integer,Integer> map2 = new HashMap();
        
        int sum=0;
        for(var entry:map.entrySet())
        {
            map2.put(entry.getKey(),sum);
            sum+=entry.getValue();
        }
        
        int i=0;
        for(int x:nums)
        {
            res[i++] = map2.get(x);
        }
        return res;
    }
}
