class Solution {
    public int longestPalindrome(String s) {
        int[] small = new int[26];
        int[] big = new int[26];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
            small[s.charAt(i)-'a']++;
            else
            big[s.charAt(i)-'A']++;
        }
        boolean isPresent = false;
        int sum=0;
        for(int x:small)
        {
            if(x%2==0)
                sum+=x;
            else
            {
                isPresent =true;
                sum+=x-1;
            }
        }
        for(int x:big)
        {
            if(x%2==0)
                sum+=x;
            else
            {
                isPresent =true;
                sum+=x-1;
            }       
        }
        if(isPresent)
        return sum+1;
        return sum;
    }
}
