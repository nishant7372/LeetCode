class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=max(nums,i,dp)+1;
            if(dp[i]>max)
                max=dp[i];
        }
        return max;
    }
    
    
    private int max(int[] nums,int j,int[] dp)
    {
        int max=-1;
        for(int i=0;i<j;i++)
        {
            if(nums[i]<nums[j]&&dp[i]>max)
                max=dp[i];
        }
        if(max==-1)
            return 0;
        else
            return max;
    }
}
