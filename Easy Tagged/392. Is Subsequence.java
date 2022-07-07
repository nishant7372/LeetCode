class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i!=s.length()&&j!=t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            i++;
            j++;
            if(s.length()-i>t.length()-j)
                return false;
        }
     
        return i==s.length()? true:false;
    }
}
