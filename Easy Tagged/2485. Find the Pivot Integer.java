class Solution {
    public int pivotInteger(int n) {
        int i=1;
        
        long sum1=0;
        long sum2=(n*(n+1))/2;
        
        while(i<=n)
        {
            sum2-=(i-1);
            sum1+=i;
            if(sum1==sum2)
                return i;
            i++;
        }
        return -1;
    }
