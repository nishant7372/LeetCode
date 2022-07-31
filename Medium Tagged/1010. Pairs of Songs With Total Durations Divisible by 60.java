class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] a = new int[60];
        
        for(int i=0;i<time.length;i++)
        {
            a[time[i]%60]++;
        }
        
        int c=0;
        
        for(int i=0;i<59;i++)
        {
            for(int j=i+1;j<60;j++)
            {
                if(a[i]!=0&&(i+j)%60==0)
                {
                    c+=a[i]*a[j];
                }      
            }
        }
        if(a[0]>=2)
            c+=((long)(a[0]-1)*(a[0]))/2;
        if(a[30]>=2)
            c+=((long)a[30]*(a[30]-1))/2;
        return c;
    }
}
