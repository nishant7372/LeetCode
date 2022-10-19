class Solution {
    public int findMaxK(int[] nums) {
        int max=0;
        for(int x:nums)
        {
            if(x>max)
                max=x;
        }
        int[] a = new int[max+1];
        int[] b = new int[max+1];
        
        for(int x:nums)
        {
            if(x>0)
                a[x]=1;
            else if(Math.abs(x)<=max)
                b[Math.abs(x)]=1;
        }
        
        for(int i=max;i>0;i--)
        {
            if(a[i]==1&&b[i]==1)
                return i;
        }
        return -1;
    }
}
