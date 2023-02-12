class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res=0;
        int i=0, j=nums.length-1;
        while(i<=j){
            long c = i==j? nums[i]:Long.parseLong(nums[i]+""+nums[j]);
            res+=c;
            i++;
            j--;
        }
        return res;
    }
}
