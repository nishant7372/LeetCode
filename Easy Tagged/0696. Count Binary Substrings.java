// O(n) solution Beats 54%

class Solution {
    int c1=0, c2=0;
    public int countBinarySubstrings(String s) {
        int i=0, res=0;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)=='1'){
                c1++;
                i++;
            }
            res+=Math.min(c1,c2);
            c2=0;
            while(i<s.length() && s.charAt(i)=='0'){
                c2++;
                i++;
            }
            res+=Math.min(c1,c2);
            c1=0;
        }
        return res;
    }
}
