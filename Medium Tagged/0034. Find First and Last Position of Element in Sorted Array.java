class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = Search1(nums,target);
        int last = Search2(nums,target);
        if(first>last)
        return new int[]{-1,-1};
        return new int[]{first,last};
    }

    private int Search1(int[] nums,int target)
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
    
    private int Search2(int[] nums,int target)
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
