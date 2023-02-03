// 1ms runtime --> Modular Exponentiation Beats 45%

class Solution {
    public double myPow(double x, int n) {
        boolean neg=false;
        if(n<0)
           neg = true;
        long p = Math.abs((long)n);
        double ans = 1.0;
        while(p>0){
            if(p%2==1)
               ans = ans*x;
            x=x*x;
            p/=2;
        }
        return neg? 1/ans : ans;
    }
}

// 0ms runtime --> Modular Exponentiation Beats 100%

class Solution {
    public double myPow(double x, int n) {
        boolean neg=false;
        if(n<0)
           neg = true;
        n = Math.abs(n);
        if(n<0 && x!=-1d && x!=1d)
           return 0d;
        double ans = 1.0;
        while(n>0){
            if(n%2==1)
               ans = ans*x;
            x=x*x;
            n/=2;
        }
        return neg? 1/ans : ans;
    }
}

// 0ms runtime --> Modular Exponentiation Beats 100%

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}
