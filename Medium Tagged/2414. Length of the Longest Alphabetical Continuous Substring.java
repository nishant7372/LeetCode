class Solution {
    public int longestContinuousSubstring(String s) {
        int max=1;
        int c=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1)-1)
                c++;
            else
            {
                max=Math.max(max,c);
                c=1;
            }
        }
        return Math.max(max,c);
    }
}
