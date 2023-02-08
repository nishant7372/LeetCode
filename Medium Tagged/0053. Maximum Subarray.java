class Solution {
    public int maxSubArray(int[] nums) {
        int max_Sum=Integer.MIN_VALUE;
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
            if(sum>max_Sum)
                max_Sum=sum;
            if(sum<0)
                sum=0;
        }
        return max_Sum;
    }
}
