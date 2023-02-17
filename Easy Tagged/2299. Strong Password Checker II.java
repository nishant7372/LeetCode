// 1ms runtime Beats 82%

class Solution {
    public boolean strongPasswordCheckerII(String s) {
        int upper=0, lower=0, digit=0, spc=0;

        String special="!@#$%^&*()-+";
        if(s.length()<8)
            return false;
        Character prev = null;
        for(char ch: s.toCharArray())
        {
            if(Character.isUpperCase(ch))
                upper=1;
            else if(Character.isLowerCase(ch))
                lower=1;
            else if(Character.isDigit(ch))
                digit=1;
            else if(special.indexOf(ch)>=0)
                spc=1;
            if(prev!=null && ch==prev)
                return false;
            prev=ch;
        }
         // 1-> true, 0-> false
        if(upper==0||lower==0||digit==0||spc==0)
            return false;
        return true;
    }
}
