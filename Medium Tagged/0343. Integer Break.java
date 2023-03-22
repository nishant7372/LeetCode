class Solution {
    public int integerBreak(int n) {
        Integer[] dp = new Integer[n+1];
        return solve(n,1,dp);
    }

    private int solve(int target,int i,Integer[] dp){
        if(i==dp.length-1 || target<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[target]!=null){
            return dp[target];
        }
        int pick = i*solve(target-i,i,dp);
        int notPick = solve(target,i+1,dp);
        return dp[target]=Math.max(pick,notPick);
    }
}
