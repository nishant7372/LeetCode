class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] a = new int[code.length];
        
        if(k>0)
        {
            a[0]=calcSum(1,k,code);
            for(int i=1;i<code.length;i++)
            {
                if(i+k==code.length)
                    k=-i;
                a[i]=a[i-1]-code[i]+code[i+k];
            }
        }
        else if(k<0)
        {
            k=-1*k;
            a[0]=calcSum(code.length-k,code.length-1,code);
            for(int i=1;i<code.length;i++)
            {
                if(i-k-1==0)
                    k=code.length+i-1;
                a[i]=a[i-1]+code[i-1]-code[code.length-k+i-1];
            }
        }
        return a;
    }
    
    private int calcSum(int start,int end,int[] code)
    {
        int sum=0;
        for(int i=start;i<=end;i++)
        {
            sum+=code[i];
        }
        return sum;
    }
}
