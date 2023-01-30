// Code 1 --> 0ms runtime Faster than 100%

class Solution {
    static int mod = 1000000007;
    public int monkeyMove(int n) {
        long a = 2;
        long ans=1;
        while(n>0) {
            if(n%2==1)
                ans=(ans*a)%mod;
            a=(a*a)%mod;
            n/=2;
        }
        return (int)((ans-2+mod)%mod);
    }
}

// Code 2 --> 0ms runtime Faster than 100%

class Solution {
    static int mod = 1000000007;
    public int monkeyMove(int n) {
        long a = 2;
        long ans=1;
        while(n>0) {
            if((n&1)!=0)
                ans=(ans*a)%mod;
            a=(a*a)%mod;
            n=n>>1;
        }
        return (int)((ans-2+mod)%mod);
    }
}
