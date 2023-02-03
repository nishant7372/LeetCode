// 0ms runtime Beats 100%

class Solution {
    public boolean checkString(String s) {
        if(s.indexOf('b')==-1)
           return true;
        if(s.indexOf('b')<s.lastIndexOf('a'))
           return false;
        return true;
    }
}

// 0ms runtime Beats 100%

class Solution {
    public boolean checkString(String s) {
        String m="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='b'){
                m = s.substring(i,s.length());
                break;
            }
        }
        
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)=='a')
                return false;
        }
        return true;
    }
}
