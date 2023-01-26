class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        return count(s);
    }
    
    private int count(String s)
    {
        int j = s.length()-1;
        int c=0;
        while(j>=0&&s.charAt(j--)!=' ')
            c++;
        return c;
    }
}
