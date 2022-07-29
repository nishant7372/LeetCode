class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> a = new ArrayList<>();
      
        for(String s:words)
        {
            if(check(s,pattern))
                a.add(s);
        }
        return a;
    }
    
    private boolean check(String s, String t)
    {
        char[] a = new char[26];
        
        for(int i=0;i<s.length();i++)
        {
           if(a[s.charAt(i)-'a']=='\u0000')
           {
               if(contains(a,t.charAt(i)))
                   return false;
               a[s.charAt(i)-'a']=t.charAt(i);
           }  
           else
           {
               if(a[s.charAt(i)-'a']!=t.charAt(i))
                   return false;
           }
        }
        return true;
    }
    
    private boolean contains(char[] a,char target)
    {
        for(char x:a)
            if(x==target)
                return true;
        return false;
    }
}
