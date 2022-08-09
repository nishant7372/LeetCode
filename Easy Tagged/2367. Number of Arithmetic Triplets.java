class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int c=0;
        for(int x:nums)
        {
            if(Arrays.binarySearch(nums,(x+diff))>=0&&Arrays.binarySearch(nums,(x+2*diff))>=0)
                c++;
        }
        return c;
    }
}
