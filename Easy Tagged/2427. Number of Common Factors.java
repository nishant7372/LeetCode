class Solution {
    public int commonFactors(int a, int b) {
        int i = a>b? b:a;
        int c=0;
        for(int j=1;j<=i;j++)
        {
            if(a%j==0 && b%j==0)
                c++;
        }
        return c;
    }
}
