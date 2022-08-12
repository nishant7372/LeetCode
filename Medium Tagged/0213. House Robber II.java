class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(maxRobbed(0,nums.length-1,nums),maxRobbed(1,nums.length,nums));
    }
    
    
    private int maxRobbed(int start,int end,int[] nums)
    {
        int max=0;
        int prev=0;
        for(int i=start;i<end;i++)
        {
            int curr = nums[i]+max;
            if(prev>max)
                max=prev;
            prev=curr;
        }
        if(prev>max)
            max=prev;
        
        return max;
    }
}
