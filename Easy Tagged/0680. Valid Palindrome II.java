//8ms runtime Beats 87% 2-pointers

class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return check(s,i+1,j) || check(s,i,j-1);
            i++;
            j--;
        }
        return true;
    }

    private boolean check(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
