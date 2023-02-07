// Beats 96% 5ms runtime -> O(n) time and O(n) space

class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        int[] smaller = new int[n];

        for(int i=n-1;i>=0;i--)
            smaller[i]=min=Math.min(min,nums[i]);
        
        int sum=0, max=nums[0];
        for(int i=1;i<n-1;i++)
        {
            // no need to increment 2 times as if this condition is true then next condition is also true
            if(max<nums[i] && nums[i]<smaller[i+1]) 
                sum++;
            if(nums[i-1]<nums[i] && nums[i]<nums[i+1])
                sum++;
            max = Math.max(max,nums[i]);
        } 
        return sum;
    }
}
