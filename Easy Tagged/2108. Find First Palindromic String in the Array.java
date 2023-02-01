// Beats 99.76% 2ms runtime 2-pointers

class Solution {
    public String firstPalindrome(String[] words) {
        for(String s:words)
        {
            if(isPalindrome(s))
            return s;
        }
        return ""; 
    }
    
    private boolean isPalindrome(String s)
    {
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=(s.charAt(j--)))
                return false;
        }
        return true;
    }
}
