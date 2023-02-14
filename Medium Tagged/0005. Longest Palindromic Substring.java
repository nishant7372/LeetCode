// Beats 79%
// Using Substring Updation

class Solution {
    private int max=0;
    public String longestPalindrome(String s) {
        int n = s.length();
        String res="";
        for(int i=0;i<n;i++){
           res=find(i,i+1,s,res);
        }
        for(int i=1;i<n;i++){
           res=find(i-1,i+1,s,res);
        }
        return max==0? s.charAt(0)+"" : res;
    }
    
    private String find(int j,int k,String s,String t)
    {
        int c=0;
        while(j>=0&&k<s.length())
        {
            if(s.charAt(j)!=s.charAt(k))
                break;
            c++;
            j--;
            k++;
        }
        max=Math.max(c,max);
        return max==c? s.substring(j+1,k):t;
    }
}


// Beats 60% 
// Tracking begin and end index of longest palindromic substring  (Works when we need the first palindromic substring)

class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[]{0,1};
        for(int i=0;i<s.length();i++){
            int[] temp = find(i,i+1,s);
            if(res[1]-res[0]<temp[1]-temp[0])
               res=temp;
        }
        for(int i=1;i<s.length();i++) {
            int[] temp = find(i-1,i+1,s);
            if(res[1]-res[0]<temp[1]-temp[0])
               res=temp;
        }
        return s.substring(res[0],res[1]);
    }
    
    private int[] find(int j,int k,String s)
    {
        while(j>=0&&k<s.length())
        {
            if(s.charAt(j)!=s.charAt(k))
                return new int[]{j+1,k};
            j--;
            k++;
        }
        return new int[]{j+1,k};
    }
}
