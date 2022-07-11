class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max=0;
        for(int x:nums)
            if(max<x)
                max=x;
        int[] sortedArray = new int[max+1];
        
        for(int x:nums)
        {
            sortedArray[x]++;
        }
        
        int[] a = new int[max+nums.length];
        int fill=nums[0];
        int c=0;
        for(int i=0;i<sortedArray.length;i++)
        {
            while(sortedArray[i]>0)
            {
            if(a[i]==1)
            {
                c+=fill-i;
                a[fill]=1;
                    fill++;
            }
            else
            {
                a[i]=1;
                fill=i+1;
            }
                sortedArray[i]--;
            }
        }
        return c;
    }
}
