//Method 1
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Map<String,Integer> map = new HashMap<>(); 
        
        for(String s:targetWords)
        {
            char[] a = new char[26];
            for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']++;
            String t = String.valueOf(a);
            map.put(t,map.getOrDefault(t,0)+1);
        }
       
       
        int c=0;
        for(String s:startWords)
        {
            char[] a = new char[26];
            for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']++;
            
            for(int i=0;i<26;i++)
            {
                if(a[i]==0){
                    a[i]=1;
                    String t = String.valueOf(a);
                    int val=map.getOrDefault(t,0);
                    c+=val;
                    if(val>0){
                       map.put(t,0);
                    }
                    a[i]=0;
                }
            }
        }
        
        return c;
    }
}


//Method 2
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Map<String,Integer>[] map = new HashMap[27]; 
        for(int i=1;i<=26;i++)
            map[i] = new HashMap<String,Integer>();

        char[] a;
        for(String s:targetWords)
        {
            a = new char[26];
            
            for(int i=0;i<s.length();i++)
                a[s.charAt(i)-'a']++;
            
            String t = String.valueOf(a);
            
            map[s.length()].put(t,map[s.length()].getOrDefault(t,0)+1);
        }
       
       
        int c=0;
        
        for(String s:startWords)
        {
            a = new char[26];
            
            for(int i=0;i<s.length();i++)
                a[s.charAt(i)-'a']++;
            
            for(int i=0;i<26;i++)
            {
                if(a[i]==0){
                    a[i]++;
                    String t = String.valueOf(a);
                    int val=map[s.length()+1].getOrDefault(t,0);
                    c+=val;
                    if(val>0){
                       map[s.length()+1].put(t,0);
                    }
                    a[i]--;
                }
            }
        }
        
        return c;
    }
}
