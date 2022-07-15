class Solution {
    public int removePalindromeSub(String s) {
        StringBuffer sb = new StringBuffer(s);
        if(s.equals(sb.reverse().toString()))
            return 1;
        return 2;
    }
}
