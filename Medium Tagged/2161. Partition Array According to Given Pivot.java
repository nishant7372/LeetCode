class Solution {
    public int[] pivotArray(int[] nums, int pivot) { 
        int[] a =new int[nums.length];
        int i=0;
        int b=0;
        int c=0;
        for(int x:nums)
        {
            if(x<pivot)
                b++;
            else if(x==pivot)
                c++;    
        }
        c+=b;
        for(int x:nums)
        {
            if(x<pivot)
                a[i++]=x;
            else if(x==pivot)
                a[b++]=x;
            else
                a[c++]=x;
        }
        return a;
    }
}
