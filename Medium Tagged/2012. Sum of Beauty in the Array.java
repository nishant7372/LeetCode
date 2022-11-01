class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] a = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(min>nums[i])
                min=nums[i];
            a[i]=min;
        }
        int c=0;
        int max=nums[0];
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]>max && nums[i]<a[i+1])
                c+=2;
            else if(nums[i]<nums[i+1] && nums[i]>nums[i-1])
                c+=1;
            if(nums[i]>max)
                max=nums[i];
        } 
        return c;
    }
}
