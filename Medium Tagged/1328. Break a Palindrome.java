class Solution {
    public String breakPalindrome(String s) {
       if(s.length()==1)
           return "";
       int i=0;
       StringBuffer sb = new StringBuffer(s);
       while(i<s.length() && s.charAt(i)=='a')
           i++;
       
       if((s.length()%2==1 && i==s.length()/2) || i==s.length())
       {
           sb.setCharAt(s.length()-1,'b');
           return sb.toString();
       }
       else 
       {
           sb.setCharAt(i,'a');
           return sb.toString();
       }
    }
}
