// Beats 100% --> 0ms runtime (Without Trie)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=0, i=0;
        for(String x:strs)
        {
            if(x.length()<strs[min].length())
                min=i; 
            i++;
        }
        String s=strs[min];
        int c=0;
        for(int k=s.length();k>=1;k--){
            String p = s.substring(0,k); // prefix String
            for(String x:strs){
                if(x.startsWith(p))
                   c++;
            }
            if(c==strs.length) 
               return p;
            c=0;
        }
        return "";
    }
}

