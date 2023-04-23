class Solution {
    static int mod = (int)1e9+7;
    boolean[] isPrime;
    public int beautifulPartitions(String s, int k, int minLength) {
        isPrime = new boolean[10];
        isPrime[2] = isPrime[3] = isPrime[5] = isPrime[7] = true;
        
        return solve(s,0,k,minLength,new Integer[s.length()][k+1]);
    }

    private int solve(String s,int i,int k,int minLength,Integer[][] dp){
        if(i==s.length())
            return k==0? 1:0;
        if(!isPrime[s.charAt(i)-'0'] || k<0){
            return 0;
        }
        if(dp[i][k]!=null){
            return dp[i][k];
        }
        long sum=0;
        for(int j=i+minLength-1;j<s.length();j++){
            if(isPrime[s.charAt(j)-'0']){
                continue;
            }
            sum+=solve(s,j+1,k-1,minLength,dp);
        }
        return dp[i][k] = (int)(sum%mod);
    }
}
