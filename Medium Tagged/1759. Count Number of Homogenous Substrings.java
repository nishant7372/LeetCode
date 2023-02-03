class Solution {
    static int mod = 1000000007;
    public int countHomogenous(String s) {
        long c=1;
        int sum=0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                c++;
            else{
                sum+=c*(c+1)/2%mod;
                c=1;
            }
        }
        return sum+=c*(c+1)/2%mod;
    }
}
