// Using HashMap --->  14ms runtime
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        
        for(String s:strs)
        {
            char[] freq = new char[26];
            for(char ch:s.toCharArray())
                freq[ch-'a']++;
            String key = String.valueOf(freq);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

// Brute Force --> ~1000ms runtime
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int k=0;
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i]==null)
                continue;
            res.add(new ArrayList<String>());
            res.get(k).add(strs[i]);
            for(int j=i+1;j<strs.length;j++)
            {
                if(strs[j]==null)
                    continue;
                if(isAnagram(strs[i],strs[j]))
                {
                res.get(k).add(strs[j]);
                    strs[j]=null;
                }
            }
            k++;
        }
        return res;
    }
    
   private boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
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
            if(a[i]!=b[i])
                return false;
        return true;
    }
}
