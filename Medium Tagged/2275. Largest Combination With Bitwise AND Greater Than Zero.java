// Beats 91%

class Solution {
    // bitwise & of two odd no.'s is always > 0
    // bitwise & of n same no.'s is always = no.
    public int largestCombination(int[] nums) {
        int max=0, t=24;
        while(t-->0){
            int c=0;
            for(int i=0;i<nums.length;i++)
            {
                c+=nums[i]&1;
                nums[i]>>=1;
            }
            max=Math.max(max,c);
        };
        
        return max;
    }
}
