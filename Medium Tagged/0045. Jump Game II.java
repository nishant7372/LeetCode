class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int[] dp = new int[nums.length];
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=min(i,nums,dp)+1;
        }
        return dp[nums.length-1];
    }
    
    
    private int min(int j,int[] nums,int[] dp)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<j;i++)
        {
            if(nums[i]+i>=j&&dp[i]<min)
                min=dp[i];
        }
        return min;
    }
}
