// Tabulation - Bottom Up
// Beats 100%
// TC -> O(n^2)
// SC -> O(n)

class Solution {
    static int mod = (int)1e9+7;
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            long num=0, sum=0;
            for(int j=i;j<s.length();j++){
                num=num*10+(s.charAt(j)-'0');
                if(num==0 || num>k)
                    break;
                sum+=dp[j+1];
            }
            dp[i] = (int)(sum%mod);
        }
        return dp[0];
    }
}


// Memoization - Top Down
// Beats 76%
// TC -> O(n^2)
// SC -> O(n)

class Solution {
    static int mod = (int)1e9+7;
    public int numberOfArrays(String s, int k) {
        return solve(s,0,k,new Integer[s.length()]);
    }

    private int solve(String s,int i,int k,Integer[] dp){
        if(i==s.length())
            return 1;
        if(dp[i]!=null){
            return dp[i];
        }
        long sum=0, num=0;
        for(int j=i;j<s.length();j++){
            num=num*10+(s.charAt(j)-'0');
            if(num>k || num==0){
                break;
            }
            sum+=solve(s,j+1,k,dp);
        }
        return dp[i] = (int)(sum%mod);
    }
}
