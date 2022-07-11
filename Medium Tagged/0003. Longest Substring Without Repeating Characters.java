class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] a;
        for(int i=Math.min(s.length()-1,127);i>=0;i--)
        {
            a = new int[128];
            for(int j=0;j<=i;j++)
                a[s.charAt(j)]++;

            if(check(a))
                return i+1;
            
            for(int j=1;j<s.length()-i;j++)
            {
               a[s.charAt(j-1)]--;
               a[s.charAt(i+j)]++;
               if(check(a))
                return i+1;
            }
        }
        return 0;
    }
    
    private boolean check(int[] a)
    {
        for(int x:a)
            if(x>1)
                return false;
        return true;
    }
}
