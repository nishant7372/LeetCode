class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        for(int i=0;i<26;i++)
        {
            int c=0;
            int l=0;
        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j)-'A'!=i)
                c++;
            while(c>k)
            {
                if(s.charAt(l++)-'A'!=i)
                    c--;
            }
            max=Math.max(max,j-l+1);
        }
        }
        return max;
    }
}
