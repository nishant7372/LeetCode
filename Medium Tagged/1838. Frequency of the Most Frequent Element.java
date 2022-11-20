class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max=0;
        for(int x:nums)
        {
            if(x>max)
                max=x;
        }
        int[] a = new int[max+1];
        
        for(int x:nums)
        {
            a[x]++;
        }
        int m=0;  
        for(int i=0;i<a.length;i++)
        {
            while(a[i]-->0)
            {
                nums[m++]=i;
            }
        }
        int i=0;
        int j=nums.length-1;
        
        while(i<j)
        {
            int temp = nums[j];
            nums[j--]=nums[i];
            nums[i++]=temp;
        }
        max=0;
        
        for(i=0;i<nums.length;i++)
        {
            int sum=0;
            if(nums.length-i<=max)
                break;
            for(j=i;j<nums.length;j++)
            {
                sum+=nums[i]-nums[j];
                if(sum>k)
                    break;
            }
            max=Math.max(max,j-i);
        }
        return max;
    }
}
