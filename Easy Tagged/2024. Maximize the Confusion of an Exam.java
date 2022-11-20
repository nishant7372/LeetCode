class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
       return Math.max(solve(s,k,'T'),solve(s,k,'F'));
    }
    
    private int solve(String s,int k,char ch)
    {
        int i=0;
        int max=0;
        int c=0;
        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j)!=ch)
                c++;
            while(c>k)
            {
                if(s.charAt(i++)!=ch)
                    c--;
            }
            max= Math.max(max,j-i+1);
        }
        return max;
    }
}
