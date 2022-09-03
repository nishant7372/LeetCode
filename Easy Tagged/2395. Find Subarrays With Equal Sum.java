class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length-1;i++)
        {
            int sum = nums[i]+nums[i+1];
            int prev=set.size();
            set.add(sum);
            if(set.size()==prev)
                return true;
        }
        return false;
    }
}
