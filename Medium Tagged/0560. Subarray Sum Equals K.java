class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
           sum+=nums[i];
           c+=check_sum(nums,sum,k,i);
        }
        return c;
    }
    
    private int check_sum(int[] nums, int sum, int k,int end)
    {
        int c=0;
        if(sum==k)
            c++;
        for(int i=0;i<end;i++)
        {
            sum-=nums[i];
            if(sum==k)
                c++;
        }
        return c;
    }
}
