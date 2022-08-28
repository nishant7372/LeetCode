class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int c=0;
        StringBuffer sb = new StringBuffer(s);
            for(int i=0;i<sb.length()-1;i++)
            {
                if(sb.charAt(i)=='0'&&sb.charAt(i+1)=='1')
                {
                    sb.setCharAt(i,'1');
                    sb.setCharAt(i+1,'0');
                    i--;
                    c++;
                }
            }
        return c;
    }
}
