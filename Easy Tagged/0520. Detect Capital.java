class Solution {
    public boolean detectCapitalUse(String word) {
        int c=0;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>=97)
                c++;
        }
        if(c==0||c==word.length())
            return true;
        if(c==word.length()-1&&word.charAt(0)<=90)
            return true;
        else
            return false;
    }
}
