class Solution {
    public String removeOccurrences(String s, String part) {
        int a=s.indexOf(part);
        while(a>=0)
        { 
            StringBuffer sb = new StringBuffer(s.substring(0,a)+s.substring(a+part.length(),s.length()));
            a=sb.indexOf(part);
            s=sb.toString();
        }
        return s;
    }
}
