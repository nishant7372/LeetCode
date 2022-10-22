class Solution {
    public String minWindow(String s, String t) {
        
        int[] a = new int[52]; //for String t  
        int[] b = new int[52]; //for window of String s
        
        int[] res = new int[2];  //store start & end of minString
        
        for(int i=0;i<t.length();i++)  //for String t
        {
            if(t.charAt(i)<='Z')
            a[t.charAt(i)-'A']++;
            else
            a[t.charAt(i)-'a'+26]++;
        }
        
        int left=0;  //sliding window left pointer
        int right=0; //sliding window right pointer
        
        while(right<=s.length()&&left<s.length())
        {            
            if(compare(a,b)) //string found
            {
                if(res[1]-res[0]==0)
                {
                    res[0]=left;
                    res[1]=right;
                }
                else if(res[1]-res[0]>right-left)
                {
                    res[0]=left;
                    res[1]=right;
                }
                if(s.charAt(left)<='Z')
                    b[s.charAt(left++)-'A']--;
                else
                    b[s.charAt(left++)-'a'+26]--;
            }
            else
            {
                if(right<s.length())
                {
                    if(s.charAt(right)<='Z')
                        b[s.charAt(right++)-'A']++;
                    else
                        b[s.charAt(right++)-'a'+26]++;
                }
                else
                    right++;
            }
        }
        return s.substring(res[0],res[1]);
    }
    
    private boolean compare(int[] a,int[] b)
    {
        for(int i=0;i<52;i++)
        {
            if(a[i]>0 && a[i]>b[i])
                return false;
        }
        return true;
    }
}
