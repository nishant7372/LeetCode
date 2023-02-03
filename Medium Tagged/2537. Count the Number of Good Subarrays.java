// Method 1 --> Counting Good Subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long ans=0; // good subarrays 
        int pairs=0, i=0, j=0, n=nums.length; // i- right pointer and j - left pointer
        while(i<n)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1); //increasing freq of nums[i]
            if(map.get(nums[i])>1) 
                pairs+=map.get(nums[i])-1;  // increasing number of pairs

            while(pairs>=k)
            {
                ans+=n-i; // counting good subarrays
                if(map.get(nums[j])>1)
                   pairs-=(map.get(nums[j])-1); // decreasing number of pairs
                map.put(nums[j],map.getOrDefault(nums[j],0)-1); //decreasing freq of nums[j]
                j++; //incrementing left pointer
            }
            i++; //incrementing right pointer
        }
        return ans; // good subarrays
    }
}

// Method 2 --> Counting Good Subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long bad=0; // bad subarrays 
        int pairs=0, i=0, j=0, n=nums.length; // i- right pointer and j - left pointer
        while(i<n)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1); //increasing freq of nums[i]
            if(map.get(nums[i])>1) 
                pairs+=map.get(nums[i])-1;  // increasing number of pairs

            while(pairs>=k)
            {
                if(map.get(nums[j])>1)
                   pairs-=(map.get(nums[j])-1); // decreasing number of pairs
                map.put(nums[j],map.getOrDefault(nums[j],0)-1); //decreasing freq of nums[j]
                j++; //incrementing left pointer
            }
            bad+=(i-j+1); // counting no. of bad subarrays 
            i++; //incrementing right pointer
        }
        return ((long)n*(n+1)/2)-bad; // good subarrays = total - bad subarrays
    }
}
