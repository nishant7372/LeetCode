// 0ms runtime, Beats 100%
// Using LowerBound and UpperBound

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums,target);
        int last = upperBound(nums,target);
        if(first>last)
           return new int[]{-1,-1};
        return new int[]{first,last};
    }

    private int lowerBound(int[] nums,int target)
    {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]<target)
               start=mid+1;
            else
               end=mid-1;
        }
        return start;
    }
    
    private int upperBound(int[] nums,int target)
    {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]>target)
               end=mid-1;
            else
               start=mid+1;
        }
        return end;
    }
}
