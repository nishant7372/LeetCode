class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return generate(nums,target,0,dp);
    }
    
    
    private int generate(int[] nums,int target,int sum,int[] dp)
    {
        if(sum>target)
        return 0;
        if(sum==target)
        return 1;
        if(dp[sum]!=-1)
            return dp[sum];
        int ans=0;
        for(int x:nums)
        {
            if(sum+x>target)
            break;
            ans+=generate(nums,target,sum+x,dp);
        }
        return dp[sum]=ans;
    }
}
