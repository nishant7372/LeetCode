class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length())
        {
            if(s.charAt(i)==t.charAt(j)){
                j++;
            }
            if(j==t.length())
                return 0;
            i++;
        }
        return t.length()-j;
    }
}
