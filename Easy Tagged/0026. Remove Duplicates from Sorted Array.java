class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]!=nums[i+1])
            {
            nums[k]=nums[i];
            k++;
            }
        }
        nums[k]=nums[nums.length-1];
        return k+1;
    }
}
