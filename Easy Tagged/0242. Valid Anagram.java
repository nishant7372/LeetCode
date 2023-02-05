// Method 1 --> Beats 100% 1ms runtime

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(char ch:s.toCharArray())
            a[ch-'a']++;
         for(char ch:t.toCharArray())
            b[ch-'a']++;
        
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
}


// Method 2 --> Beats 60% 4ms runtime

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
            b[t.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
}
