class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor=0;
        if(nums2.length%2==1){
        for(int x:nums1)
            xor^=x;
        }
        if(nums1.length%2==1){
        for(int x:nums2)
            xor^=x;
        }
        return xor;
    }
}
