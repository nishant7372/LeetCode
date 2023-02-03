class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++)
           sum+=calc(nums,i);
        return sum;
    }
    
    private long calc(int[] nums,int start)
    {
        long sum=0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=start;i<nums.length;i++)
        {
            if(nums[i]>max)
                max=nums[i];
            if(nums[i]<min)
                min=nums[i];
            sum+=max-min;
        }
        return sum;
    }
}
