class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0;
        long sum=0;
        int c=0;
        int maxE=0;
        for(int x:nums)
        {
            if(x>maxE)
                maxE=x;
        }
        int[] a = new int[maxE+1];
        for(int i=0;i<k;i++)
        {
            if(a[nums[i]]++==0)
                c++;
            sum+=nums[i];
        }
        
        if(sum>max && c==k)
            max=sum;
        for(int i=k;i<nums.length;i++)
        {
            if(a[nums[i]]++==0)
                c++;
            sum+=nums[i];
            if(a[nums[i-k]]--==1)
                c--;
            sum-=nums[i-k];
            if(sum>max && c==k)
            max=sum;
        }
        return max;
    }
}
