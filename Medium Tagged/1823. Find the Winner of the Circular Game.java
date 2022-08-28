class Solution {
    public int findTheWinner(int n, int k) {
        int[] a = new int[n];
        int out=0;
        int i=0;
        while(out!=n-1)
        {
            int m=k;
            while(m>1)
            {
               if(a[i++]==0)
                   m--;
               if(i==n)
                   i=0;
            }
            while(a[i]!=0)
            {
                i++;
                if(i==a.length)
                    i=0;
            }
            a[i]=1;
            out++;
        }
        for(int j=0;j<a.length;j++)
        {
            if(a[j]==0)
                return j+1;
        }
        return 0;
    }
}
