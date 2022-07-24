class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int c=0;
        long count=0;
        for(int x:nums)
        {
            if(x==0)
            {
                c++;
                count+=c;
            }   
            else
                c=0;
        }
        return count;
    }
}
