// 20ms runtime O(n) time and O(1) space

// No. of subarrays with exactly k odd = No. of subarrays with at most k odd - No. of subarrays with at most k-1 odd.

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return AtMostKOdd(nums,k) - AtMostKOdd(nums,k-1);
    }

    private int AtMostKOdd(int[] nums,int k){
        int i=0, j=0, odd=0, count=0;
        while(j<nums.length)
        {
            if(nums[j]%2==1)
                odd++;
                
            while(odd>k){
                if(nums[i++]%2==1)
                    odd--;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}
