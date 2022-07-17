class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] a = new int[101];
        
        for(int x:nums)
        {
            a[x]++;
        }
        
        int pairs=0;
        int left=0;
        for(int x:a)
        {
            pairs+=x/2;
            left+=x%2;
        }
        return new int[]{pairs,left};
    }
}
