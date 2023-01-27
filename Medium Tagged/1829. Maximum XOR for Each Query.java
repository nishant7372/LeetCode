//Beats 100% 2ms runtime

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int xor=0;
        for(int x:nums){
            xor^=x;
        }
        int k = (int)Math.pow(2,maximumBit)-1;
        for(int i=0;i<nums.length;i++){
            res[i]=xor^k;
            xor^=nums[nums.length-i-1];
        }
        return res;
    }
}
