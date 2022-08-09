class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        int i=0;
        for(int x:nums)
        {
            if(i>reach)
                return false;
            if(reach<i+x)
                reach=i+x;
            if(reach==nums.length-1)
                return true;
            i++;
        }
        return true;
    }
}
