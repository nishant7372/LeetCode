class Solution {
    public String smallestNumber(String pattern) {
        int[] a = new int[pattern.length()+1];
        int c=1;
        for(int i=0;i<=pattern.length();i++)
        {
            if(i==pattern.length()||pattern.charAt(i)=='I')
            {
                int x=i;
                a[x--]=c++;
                while(x>=0&&a[x]==0)
                    a[x--]=c++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int x:a)
            sb.append(x);
        return sb.toString();
    }
}
