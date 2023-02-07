// Beats 80% 3ms runtime

class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] smaller = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            smaller[i] = min;
        }
        int max=Integer.MIN_VALUE;
        int i=0;
        for(int x:nums){
            max=Math.max(max,x);
            if(max<=smaller[++i])
               return i;
        }
        return -1;
    }
}
