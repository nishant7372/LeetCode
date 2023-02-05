class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> a = new ArrayList<>();
        if(s.length()<p.length())
            return a;
        String temp = s.substring(0,p.length());
        
        //Frequency HashTable for String p
        int[] freq1 = new int[26];
        //Frequency HashTable for String s
        int[] freq2 = new int[26];
        
        for(int i=0;i<p.length();i++)
        {
            freq1[p.charAt(i)-'a']++;      //for string p
            freq2[temp.charAt(i)-'a']++;   //for 1st substring of s
        }
        
        if(equal(freq1,freq2))
                a.add(0);
        
        for(int i=1;i<s.length()-p.length()+1;i++)
        {
            freq2[s.charAt(i-1)-'a']--;
            freq2[s.charAt(i+p.length()-1)-'a']++;
            if(equal(freq1,freq2))
                a.add(i);
        }
        return a;
    }

    private boolean equal(int[] a,int[] b)
    {
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
}
