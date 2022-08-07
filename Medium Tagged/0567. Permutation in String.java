class Solution {
    public boolean checkInclusion(String s, String t) {
        if(t.length()<s.length())
            return false;
        String temp = t.substring(0,s.length());
        
        //Frequency HashTable for String s
        int[] freq1 = new int[26];
        //Frequency HashTable for String t
        int[] freq2 = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            freq1[s.charAt(i)-'a']++;      //for string s
            freq2[temp.charAt(i)-'a']++;   //for 1st substring of t
        }
        
        if(equal(freq1,freq2))
                return true;
        
        for(int i=1;i<t.length()-s.length()+1;i++)
        {
            freq2[t.charAt(i-1)-'a']--;
            freq2[t.charAt(i+s.length()-1)-'a']++;
            if(equal(freq1,freq2))
                return true;
        }
        return false;
    }
    
    private boolean equal(int[] a,int[] b)
    {
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
}
