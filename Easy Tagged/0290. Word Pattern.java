//Solution-1 
// Spliting String Using Regex
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] a = s.split(" ");
        if(a.length!=pattern.length())
            return false;
        String[] table = new String[26];
        for(int i=0;i<a.length;i++)
        {
            if(table[pattern.charAt(i)-'a']==null)
            {
                if(isPresent(a[i],table))
                    return false;
                table[pattern.charAt(i)-'a']=a[i];
            }   
            if(!table[pattern.charAt(i)-'a'].equals(a[i]))
                return false;
        }
        return true;
    }
    
    private boolean isPresent(String target,String[] table)
    {
        for(int i=0;i<26;i++)
        {
            if(table[i]!=null&&table[i].equals(target))
                return true;
        }
        return false;
    }
}


// Solution-2 
// Spliting String Using For Loop
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int k=0;
        ArrayList<String> a = new ArrayList<String>();
        String[] arr = new String[26];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                a.add(s.substring(k,i));
                k=i+1;
            }
        }
        a.add(s.substring(k,s.length()));
        if(a.size()!=pattern.length())
            return false;
        for(int i=0;i<a.size();i++)
        {
            if(arr[pattern.charAt(i)-'a']==null)
            {
                if(isPresent(a.get(i),arr))
                    return false;
                arr[pattern.charAt(i)-'a']=a.get(i);
            }   
            if(!arr[pattern.charAt(i)-'a'].equals(a.get(i)))
                return false;
        }
        return true;
    }
    
    private boolean isPresent(String target,String[] arr)
    {
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=null&&arr[i].equals(target))
                return true;
        }
        return false;
    }
}
