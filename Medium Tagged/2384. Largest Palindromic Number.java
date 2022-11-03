class Solution {
    public String largestPalindromic(String num) {
        int[] a = new int[10];
        
        for(int i=0;i<num.length();i++)
            a[num.charAt(i)-'0']++;
        
        int c=0;
        int isPresent = -1;   //tracking odd
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==1)
                isPresent=i;
            sb.append((i+"").repeat(a[i]/2));
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='0'){
            if(isPresent!=-1)
                return isPresent+"";
            else
                return "0";
        }
            
        String t = sb.toString();
        sb.reverse();
        if(isPresent!=-1)
            sb.append(isPresent);
        sb.append(t);
        return sb.toString();
    }
}
