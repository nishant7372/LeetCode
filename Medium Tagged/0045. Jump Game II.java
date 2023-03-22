// Greedy Approach, Beats 99.7%
// TC -> O(n)
// SC -> O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int currReach=0, i=0, jumps=0, prevReach=0;
        for(int x:nums){
            currReach = Math.max(currReach,i+x);
            if(currReach>=nums.length-1){
                return jumps+1;
            }
            if(i==prevReach){
                jumps++;
                prevReach = currReach;
            }
            i++;
        }
        return jumps;
    }
}

// Dp - Tabulation - Bottom Up Approach
// TC -> O(n^2)
// SC -> O(n)
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int[] dp = new int[nums.length];
        dp[0]=0; dp[1]=1;
        for(int i=1;i<nums.length;i++){
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


// Dp - Memoization - Top down Approach
// TC -> O(n^2)
// SC -> O(n) + Recursive stack space
class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return solve(nums,0,dp);
    }

    private int solve(int[] nums,int i,Integer[] dp){
        if(i==nums.length-1){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int minJumps=10000000;
        for(int j=Math.min(nums.length-1,nums[i]+i);j>i;j--){
            minJumps = Math.min(minJumps,solve(nums,j,dp));
        }
        return dp[i] = minJumps+1;
    }
}
