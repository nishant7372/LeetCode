// 3ms runtime Beats 97.20% 2-pointers

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0, j=s.length()-1;

        while(i<j)
        {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
        
    }
}
