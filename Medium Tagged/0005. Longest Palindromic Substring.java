// Method 1 -> Two pointer based O(n^2) time and O(1) space 
// 19ms runtime Beats 84%

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res=Character.toString(s.charAt(0));
        for(int i=0;i<n;i++){
           res=find(i,i+1,s,res); // even length palindromic substrings
           res=find(i-1,i+1,s,res);  // odd length palindromic substrings
        }
        return res;
    }
    
    private String find(int j,int k,String s,String res)
    {
        while(j>=0&&k<s.length())
        {
            if(s.charAt(j)!=s.charAt(k))
                break;
            j--; k++;
        }
        return res.length()<k-j-1? s.substring(j+1,k):res;
    }
}

// Method 2 -> Two pointer based O(n^2) time and O(1) space
// 25ms runtime Beats 60% 
// Tracking begin and end index of longest palindromic substring

class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[]{0,1};
        for(int i=0;i<s.length();i++){  
            int[] temp = find(i,i+1,s);  // even length palindromic substrings
            if(res[1]-res[0]<temp[1]-temp[0])
               res=temp;
            temp = find(i-1,i+1,s);      // odd length palindromic substrings
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
            j--; k++;
        }
        return new int[]{j+1,k};
    }
}
