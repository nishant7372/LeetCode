class Solution {
    public int numTrees(int n) {
        if(n<=2)
            return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return find(n,dp);
    }
    
    private int find(int n,int[] dp)
    {
        if(n<=0)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++)
            ans+=find(i-1,dp) * find(n-i,dp);
        return dp[n] = ans;
    }
}
