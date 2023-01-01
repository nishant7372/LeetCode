class Solution {
    public int countDigits(int n) {
        int a=n, c=0;
        while(n>0)
        {
            if(a%(n%10)==0)
                c++;
            n/=10;
        }
        return c;
    }
}
