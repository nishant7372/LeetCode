class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] a = new int[k];
        int min=0;
        for(int i=0;i<a.length;i++)
        {
            a[i]=nums[i];
            if(a[i]<a[min])
                min=i;
        } 
        
        for(int i=k;i<nums.length;i++)
        {
            if(nums[i]>a[min]){
                min=change(a,min,nums[i]);
            }
        }
        return a;
    }
    
    private int change(int[] a,int min,int x)
    {
        int minIndex=0;
        for(int i=min;i<a.length-1;i++)
        {
            a[i]=a[i+1];
            if(a[i]<a[minIndex])
              minIndex=i;
        }
        a[a.length-1]=x;
        if(x<a[minIndex])
           minIndex=a.length-1;
        for(int i=0;i<min;i++)
        {
            if(a[i]<a[minIndex])
                minIndex=i;
        }
        return minIndex;
    }
}
