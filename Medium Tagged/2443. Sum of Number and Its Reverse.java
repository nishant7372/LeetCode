class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=num/10;i<=num;i++)
        {
            if(i+reverse(i,0)==num)
                return true;
        }
        return false;
    }
    
    private int reverse(int n,int rev)
    {
        if(n==0)
            return rev;
        return reverse(n/10,rev*10+n%10);
    }
}
