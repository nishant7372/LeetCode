class Solution {
    public int minimumAverageDifference(int[] arr) {
       
        long[] nums = new long[arr.length];
        nums[0]=arr[0];
        
        for(int i=1;i<nums.length;i++)
            nums[i]=nums[i-1]+arr[i];
        
        int index=-1;
        long min=Integer.MAX_VALUE;
        long diff;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i==nums.length-1)
                diff=nums[nums.length-1]/nums.length;
            else
        diff = Math.abs((nums[i]/(i+1))-(nums[nums.length-1]-nums[i])/(nums.length-i-1));
            if(min>diff)
            {
                min=diff;
                index=i;
            }
        }
        return index;
    }
}
