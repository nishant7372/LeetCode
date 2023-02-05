// 1ms runtime Beats 100% (Sliding Window)

class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int i=0, j=0, sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length)
        {
            while(sum>=k){
                min = Math.min(j-i,min);
                sum-=nums[i++];
            }
            sum+=nums[j++];
        }
        while(sum>=k){
            min = Math.min(j-i,min);
            sum-=nums[i++];
        }
        return min==Integer.MAX_VALUE? 0:min;
    }
}
