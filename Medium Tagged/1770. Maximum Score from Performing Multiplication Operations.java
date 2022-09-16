class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new Integer[nums.length + 1][multipliers.length + 1];
       return solve(nums,multipliers,0,nums.length-1,0);
       
    }
    
    
    private int solve(int[] nums,int[] multipliers,int left,int right,int idx)
    {
        if(idx==multipliers.length)
            return 0;
        if (dp[idx][left] != null) {
            return dp[idx][left];
        }
        return dp[idx][left] = Math.max(multipliers[idx]*nums[left] + solve(nums,multipliers,left+1,right,idx+1),
        multipliers[idx]*nums[right] + solve(nums,multipliers,left,right-1,idx+1));
    }
}
