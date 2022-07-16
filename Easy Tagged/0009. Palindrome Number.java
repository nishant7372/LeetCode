class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(rev(x,0)==x)
            return true;
        return false;
        }
    
        private int rev(int n,int rev)
	    {
		if(n==0)
		return rev;
		return rev(n/10,rev*10+n%10);
        }
}
