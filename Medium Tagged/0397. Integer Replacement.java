// Memoization
class Solution {
    public int integerReplacement(int n) {
        Map<Long,Integer> dp = new HashMap<>();
        return solve(n,dp);
    }

    private int solve(long n,Map<Long,Integer> dp){
        if(n<=0){
            return -1;
        }
        if(n==1){
            return 0;
        }
        if(dp.get(n)!=null){
            return dp.get(n);
        }
        int res = (n%2==0? solve(n/2,dp):Math.min(solve(n+1,dp),solve(n-1,dp)))+1;
        dp.put(n,res);
        return res;
    }
}

// Recursion
class Solution {
    public int integerReplacement(int n) {
        return (int)solve(n);
    }

    private long solve(long n){
        if(n<=0){
            return -1;
        }
        if(n==1){
            return 0;
        }
        return (n%2==0? solve(n/2):Math.min(solve(n+1),solve(n-1)))+1;
    }
}
