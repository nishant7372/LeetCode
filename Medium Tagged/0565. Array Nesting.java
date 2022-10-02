class Solution {
    public int arrayNesting(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int c=0;
            while(nums[i]!=-1)
            {
                int temp = nums[i];
                nums[i]=-1;
                i = temp;
                c++;
            }
            max = Math.max(c,max);
        }
        return max;
    }
}
