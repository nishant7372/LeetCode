class Solution {
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
      
        for(int i=0;i<s.length();i++)
        {
            if(sb.length()>0 && sb.charAt(sb.length()-1)==s.charAt(i))
                sb.delete(sb.length()-1,sb.length());
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
