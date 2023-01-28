class Solution {
    public String addBinary(String n1, String n2) {
        StringBuffer sb = new StringBuffer();
        int i=n1.length()-1, j=n2.length()-1, c=0, s=0;
        
        while(i>-1||j>-1)
        {
            if(i>-1&&j>-1)
               s=c+n1.charAt(i)-'0'+n2.charAt(j)-'0';
            if(i<0)
               s=c+n2.charAt(j)-'0';
            if(j<0)
               s=c+n1.charAt(i)-'0'; 
            c=s/2;
            sb.append(s%2);
            i--;
            j--;
        }
        if(c!=0)
           sb.append(c);
        return sb.reverse().toString();
    }
}
