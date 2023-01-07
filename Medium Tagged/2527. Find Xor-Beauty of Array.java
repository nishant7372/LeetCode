class Solution {
    public int xorBeauty(int[] nums) {
        int xor=0;
        for(int x:nums)
            xor^=x;
        return xor;
    }
}
