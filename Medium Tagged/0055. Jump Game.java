// Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        int i=0;
        for(int x:nums){
            if(reach<i){
                return false;
            }
            reach = Math.max(reach,i+x);
            if(reach>=nums.length-1){
                return true;
            }
            i++;
        }
        return false;
    }
}

// DP - Memoization, Top-down Approach
class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length-1];
        return solve(nums,0,dp);
    }

    private boolean solve(int[] nums,int i,Boolean[] dp){
        if(i>=nums.length-1){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        for(int j=nums[i]+i;j>i;j--){
            if(solve(nums,j,dp))
                return true;
        }
        return dp[i] = false;
    }
}
