class Solution {
    public boolean isStrictlyPalindromic(int n) {
        while(int b=n-2;b>=2;b--)
        {
        StringBuffer sb = new StringBuffer();
        while(n>0)
        {
            sb.append(n%b);
            n/=b;
        }
        if(sb.toString().equals(sb.reverse().toString()))
            return true;
        }
        return false;
    }
}

// or just directly return false because base n-2 for every number n>5 will be 12 which is not a palindrome
