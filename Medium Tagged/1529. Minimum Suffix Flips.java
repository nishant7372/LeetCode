class Solution {
    public int minFlips(String s) {
        int c=0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)!=s.charAt(i+1))
                c++;
        }
        return s.charAt(0)=='0'?c:c+1;
    }
}
