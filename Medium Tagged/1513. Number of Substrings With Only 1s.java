class Solution {
    public int numSub(String s) {
        long c=0;
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                c++;
            else
            {
                sum+=(c*(c+1)/2)%1000000007;
                c=0;
            }
        }
        sum+=(c*(c+1)/2)%1000000007;
        return sum;
    }
}
