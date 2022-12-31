class Solution {
    public int smallestValue(int n) {
        boolean flag = true;
        
        while(flag)
        {
            int c=0;
            int sum = sumPrime(n);
            if(sum==n)
                return n;
            n=sum;
        }
        return 0;
    }
    
    
    private int sumPrime(int n)
    {
        int primesum = 0;
        
        int root = (int)Math.sqrt(n);
        for (int i=2; i<=root; i++) {
            while (n%i == 0) {
                n/=i;
                primesum+=i;
            }
        }

        return n>=2? primesum+n:primesum;
    }
}
