// Method 1 --> Recursive (0ms runtime Beats 100%)

class Solution {
    public int findGCD(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x:a)
        {
            if(x>max)
                max=x;
            if(min>x)
                min=x;
        }
        return gcd(max,min);
    }
        
    private int gcd(int a, int b)
    {
        if(a==0)
            return b;
        if(b==0||a==b)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(a,b-a);
    }
}

// Method 2 --> Recursive (0ms runtime Beats 100%)

class Solution {
    public int findGCD(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x:a)
        {
            if(x>max)
                max=x;
            if(min>x)
                min=x;
        }
        return gcd(max,min);
    }
        
    private int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

// Method 3 --> Iterative (0ms runtime Beats 100% (for small constraints only))

class Solution {
    public int findGCD(int[] a) {
        int min = 1000;
        int max = 0;
        for(int x:a)
        {
            if(x>max)
                max=x;
            if(min>x)
                min=x;
        }
        return gcd(max,min);
    }
	
   private int gcd(int a, int b)
   {
       int max=0;
       for(int i=1;i<=Math.min(a,b);i++){
           if(a%i==0&&b%i==0)
               max=i;
       }
       return max;
   }
}


