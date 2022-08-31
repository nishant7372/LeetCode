class Solution {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
                sb.deleteCharAt(sb.length()-1);
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
