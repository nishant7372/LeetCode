//Method 1 -> Optimized using Counting Sort
class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] a = new int[101];
        
        for(int x:nums)
        {
            a[x]++;
        }
        int c=0;
        for(int i=k+1;i<101;i++)
        {
            c+=a[i]*a[i-k];
        }
        return c;
    }
}

//Method 2 -> Brute Force
class Solution {
    public int countKDifference(int[] nums, int k) {
        int c=0;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(Math.abs(nums[i]-nums[j])==k)
                    c++;
            }
        }
        return c;
    }
}
