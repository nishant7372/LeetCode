class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int c=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                c++;
            if(c>nums.length/2)
                return nums[i];
            if(nums[i]!=nums[i+1])
                c=1;
        }
        return nums[nums.length-1];
    }
}
