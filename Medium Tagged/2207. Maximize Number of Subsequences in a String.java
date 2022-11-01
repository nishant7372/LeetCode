class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long a=0;
        long b=0;
        for(int i=0;i<text.length();i++)
        {
            if(pattern.charAt(1)==text.charAt(i))
                a++;
            else if(pattern.charAt(0)==text.charAt(i))
                b++;
        }
        if(pattern.charAt(0)==pattern.charAt(1))
        {
            return ((a+1)*a)/2;
        }
        long c=0;
        c+=Math.max(a,b);
        for(int i=0;i<text.length();i++)
        {
            if(pattern.charAt(0)==text.charAt(i))
            {
                c+=a;
            }
            if(pattern.charAt(1)==text.charAt(i))
                a--;
        }
        
        return c;
    }
}
