// 16ms runtime, Beats 98% 
// Sorting

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n-1]-nums[2],nums[n-2]-nums[1]),nums[n-3]-nums[0]); 
    }
}
