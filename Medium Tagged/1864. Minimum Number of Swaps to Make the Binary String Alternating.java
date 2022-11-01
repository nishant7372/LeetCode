class Solution {
    public int minSwaps(String s) {
        int c11=0;
        int c12=0;
        int c22=0;
        int c21=0;
        for(int i=0;i<s.length();i++)
        {
            if(i%2==0 && s.charAt(i)=='0')
                c11++;
            if(i%2==1 && s.charAt(i)=='1')
                c12++;
            if(i%2==1 && s.charAt(i)=='0')
                c21++;
            if(i%2==0 && s.charAt(i)=='1')
                c22++;
        }
        if(c11!=c12 && c21!=c22)
            return -1;
        if(c11!=c12)
            return c21;
        if(c21!=c22)
            return c12;
        return Math.min(c11,c21);
    }
}
