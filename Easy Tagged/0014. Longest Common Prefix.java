class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        String s=strs[0];
        for(String x:strs)
        {
            if(x.length()<min)
            {
               min=x.length(); 
               s=x;
            }
        }
        int c=0;
        for(int k=s.length();k>=1;k--)
        {
        for(String x:strs)
        {
            if(x.startsWith(s.substring(0,k)))
               c++;
        }
         if(c==strs.length) 
         return s.substring(0,k);
            c=0;
        }
        return "";
    }
}
