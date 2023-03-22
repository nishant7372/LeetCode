// Memoization -> DP

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,target,dp);
    }

    private int solve(int[] nums,int i,int target,int[] dp){
        if(target==0){
            return 1;
        }
        if(target<0 || i==nums.length){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int pick = solve(nums,0,target-nums[i],dp);
        int notPick = solve(nums,i+1,target,dp);

        return dp[target] = pick + notPick;
    }
}
