class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] a = mul(nums);
        int zeroes = a[0];
        int product = a[1];
        if(zeroes==0)
        {
            for(int i=0;i<nums.length;i++)
            nums[i]=product/nums[i]; 
        }
        else if(zeroes==1)
        {
            int i;
            for(i=0;i<nums.length;i++)
            {
                if(nums[i]==0)
                break;
            }
            Arrays.fill(nums,0);
            nums[i]=product;
        }
        else
            Arrays.fill(nums,0);
        return nums;
    }
    
    private int[] mul(int[] nums)
    {
        int product=1;
        int zeroes=0;
        for(int x:nums)
        {
            if(x==0)
                zeroes++;
            else
                product*=x;
        }
        return new int[]{zeroes,product};
    }
}
