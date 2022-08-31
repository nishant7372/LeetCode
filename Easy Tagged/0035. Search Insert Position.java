class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(target>nums[mid])
                start=mid+1;
            else if(nums[mid]==target)
                return mid;
            else
                end=mid-1;
        }
        return start;
    }
}
