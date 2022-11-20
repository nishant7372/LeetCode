class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
        {
            int[] res = solve(nums,i,dp);
            dp[i][0]=res[0];
            dp[i][1]=res[1];
        }
        return max(nums,dp);
    }
    
    private int[] solve(int[] nums,int j,int[][] dp)
    {
        int max=0;
        for(int i=0;i<j;i++)
        {
            if(dp[i][0]>max && nums[i]<nums[j])
                max=dp[i][0];
        }
        int sum=0;
        for(int i=0;i<j;i++)
        {
            if(dp[i][0]==max && nums[i]<nums[j])
                sum+=dp[i][1];
        }
        return new int[]{max+1,Math.max(1,sum)};
    }
    
    private int max(int[] nums,int[][] dp)
    {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(dp[i][0]>max) //length of Longest Increasing Subsequence
                max=dp[i][0];
        }
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(dp[i][0]==max) //Number of Increasing Subsequences with longest length
                sum+=dp[i][1];
        }
        return sum;
    }
}
