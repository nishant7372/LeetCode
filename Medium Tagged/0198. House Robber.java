//Method 1
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int maxRobbed=0;
        int prev=0;
        for(int x:nums)
        {
            int curr=x+maxRobbed;
            if(prev>maxRobbed)
                maxRobbed=prev;
            prev=curr;
        }
        if(prev>maxRobbed)
            maxRobbed=prev;
        return maxRobbed;
    }
}

//Method2
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] dp = new int[nums.length];
        int max=nums[0];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<nums.length;i++)
        {
            dp[i]=nums[i]+max;
            if(dp[i-1]>max)
                max=dp[i-1];
        }
        if(dp[nums.length-1]>max)
                max=dp[nums.length-1];
        return max;
    }
}
