class Solution {
    public String minWindow(String s, String t) {
        
        int[] a = new int[52];   //frequency array for String t

        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)<=90)
            a[t.charAt(i)-'A']++;
            else
            a[t.charAt(i)-'a'+26]++;
        }
        
        int left=0;
        int right=0;
        
        int[] b= new int[52];  //frequency array for substrings of s
     
        if(s.charAt(0)<=90)
            b[s.charAt(0)-'A']++;
        else
            b[s.charAt(0)-'a'+26]++;
        
        String min="";
        boolean flag=false;
        
        while(flag==false&&left<s.length())
        {            
            if(compare(a,b))
            {
                if(min.length()==0)
                min=s.substring(left,right+1);
                else
                {
                    if(min.length()>right-left+1)
                        min=s.substring(left,right+1);
                }
                if(s.charAt(left)<=90)
                    b[s.charAt(left)-'A']--;
                else
                    b[s.charAt(left)-'a'+26]--;
                left++;
            }
            else
            {
                right++;
                if(right<s.length())
                {
                    if(s.charAt(right)<=90)
                    b[s.charAt(right)-'A']++;
                    else
                    b[s.charAt(right)-'a'+26]++;
                }
                else
                flag=true;
            }
        }
        return min;
    }
    
    private boolean compare(int[] a,int[] b)
    {
        for(int i=0;i<52;i++)
        {
            if(a[i]>0)
            {
                 if(a[i]>b[i])
                 return false;
            }
        }
        return true;
    }
}
