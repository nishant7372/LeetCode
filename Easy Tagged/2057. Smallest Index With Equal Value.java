// Beats 100%, 1ms runtime, O(n) time and O(1) space

class Solution {
    public int smallestEqual(int[] nums) {
        int i=0;
        for(int x:nums)
        {
            if(i%10==x)
                return i;
            i++;
        }
        return -1;
    }
}
