class Solution {
    public int maxRepOpt1(String s) {
        int[] a = new int[26];   //Frequency Hashtable
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-'a']++;
        }
        
        int max=0;
        for(int i=0;i<26;i++)
        {
            int l=0;    //left 
            int r=0;    //right
            int c=0;    //counting number of swaps made(no. of distinct characters)
            while(r<s.length())
            {
                if(s.charAt(r)-'a'!=i)
                    c++;
                a[i]--;
                while(c>1)   // while no. distinct characters>1
                {
                    if(s.charAt(l++)-'a'!=i)
                        c--;
                    a[i]++;
                }
                if(a[i]>=0)
                max=Math.max(max,r-l+1);
                r++;
            }
        }
        return max;   //Max repeated character substring length
    }
}
