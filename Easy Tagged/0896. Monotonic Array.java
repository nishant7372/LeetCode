class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1)
            return true;
        if(nums[0]<nums[1])
          return isMonotonicIncreasing(nums,nums[0]);
        if(nums[0]>nums[1])
          return isMonotonicDecreasing(nums,nums[0]);
        else
          return isMonotonicIncreasing(nums,nums[0])||isMonotonicDecreasing(nums,nums[0]);
    }
    private boolean isMonotonicIncreasing(int[] nums,int prev)
    {
        for(int x:nums)
        {
            if(x<prev)
              return false;
            prev=x;
        }
        return true;
    }
    private boolean isMonotonicDecreasing(int[] nums,int prev)
    {
        for(int x:nums)
        {
            if(x>prev)
              return false;
            prev=x;
        }
        return true;
    }
}
