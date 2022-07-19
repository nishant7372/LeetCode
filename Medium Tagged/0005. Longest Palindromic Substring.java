class Solution {
    private int max=0;
    public String longestPalindrome(String s) {
        String t="";
        for(int i=0;i<s.length();i++)
        {
           t=func(i,i+1,s,t);
        }
        for(int i=1;i<s.length();i++)
        {
           t=func(i-1,i+1,s,t);
        }
        if(max==0)
        return s.charAt(0)+"";
        return t;
    }
    
    private String func(int j,int k,String s,String t)
    {
        int c=0;
        while(j>=0&&k<s.length())
        {
            if(s.charAt(j)==s.charAt(k))
            c++;
            else
                break;
            j--;
            k++;
        }
        max=Math.max(c,max);
        if(max==c)
        t=s.substring(j+1,k);
        return t;
    }
}
