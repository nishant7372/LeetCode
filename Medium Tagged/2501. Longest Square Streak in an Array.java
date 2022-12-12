class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int max=0;
        for(int x:nums)
        {
            if(x>max)
                max=x;
        }
        int[] a = new int[max+1];
        
        for(int x:nums)
        {
            a[x]=1;
        }
        
        int maxlen=-1;
        for(int j=0;j<a.length;j++)
        {
            int len=0;
            int i=j;
            while(i>=0 && i<a.length && a[i]==1)
            {
                a[i]=0;
                i=i*i;
                len++;
            }
            if(len>=2)
            maxlen= Math.max(maxlen,len);
        }
        return maxlen;
    }
}
