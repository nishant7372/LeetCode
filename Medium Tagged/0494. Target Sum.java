// Memoization -> 2d DP Array

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x: nums){
            total+=x;
        }
        Integer[][] dp = new Integer[nums.length][2*total+1];
        return solve(nums,target,0,0,dp,total);
    }
    
    
    private int solve(int[] nums,int target,int sum,int i,Integer[][] dp,int total)
    {
        if(i==nums.length){
            if(sum==target){
               return 1;
            }
            return 0;
        }

        if(dp[i][sum+total]!=null)
           return dp[i][sum+total];
        
        int a = solve(nums,target,sum+nums[i],i+1,dp,total);
        int b = solve(nums,target,sum-nums[i],i+1,dp,total);
        return dp[i][sum+total] = a+b;
    }
}

// Memoization -> HashMap
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> dp = new HashMap<>(); 
        return solve(nums,target,0,dp);
    }
    
    
    private int solve(int[] nums,int target,int i,Map<String,Integer> dp)
    {
        if(i==nums.length){
        if(target==0){
            return 1;
        }
        return 0;
        }

        if(dp.get(i+","+target)!=null)
           return dp.get(i+","+target);
        
        int a = solve(nums,target+nums[i],i+1,dp);
        int b = solve(nums,target-nums[i],i+1,dp);
        dp.put(i+","+target,a+b);
        return a+b;
    }
}

// Recursion 
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0);
    }
    
    
    private int solve(int[] nums,int target,int i)
    {
        if(i==nums.length){
        if(target==0){
            return 1;
        }
        return 0;
        }
        
        int a = solve(nums,target+nums[i],i+1);
        int b = solve(nums,target-nums[i],i+1);
        return a+b;
    }
}
