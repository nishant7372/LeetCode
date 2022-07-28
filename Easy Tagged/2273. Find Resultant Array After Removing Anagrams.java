class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(words[0]);
        for(int i=1;i<words.length;i++)
        {
            if(check(words[i],words[i-1])==false)
                a.add(words[i]);
        }
        return a;
    }
    
    private boolean check(String s, String t)
    {
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(int i=0;i<Math.max(s.length(),t.length());i++)
        {
            if(i<s.length())
            a[s.charAt(i)-'a']++;
            if(i<t.length())
            b[t.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}
