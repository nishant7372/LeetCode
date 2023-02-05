// 3ms runtime O(n) solution

// There can only be three scenarios for deletions such that both minimum and maximum elements are removed:
// Scenario 1: Both elements are removed by only deleting from the front.
// Scenario 2: Both elements are removed by only deleting from the back.
// Scenario 3: Delete from the front to remove one of the elements, and delete from the back to remove the other element.
// Compare which of the three scenarios results in the minimum number of moves.

class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0, max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums[max])
                max=i;
            if(nums[i]<nums[min])
                min=i;
        }
        int f = Math.min(min,max);
        int s = Math.max(min,max);
        min=Math.min(s+1,nums.length-f); // removing from front only or from end only
        return Math.min(f+1+nums.length-s,min);  // removing first from front and second from end
    }
}
