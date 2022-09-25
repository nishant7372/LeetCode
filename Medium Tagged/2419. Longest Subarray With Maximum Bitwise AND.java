class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum=0;
        for(int x:nums){
            if(x>maxNum)
                maxNum=x;
        }
        
        int max=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==maxNum)
                c++;
            else
            {
                max = Math.max(c,max);
                c=0;
            }
        }
        return Math.max(c,max);
    }
}
