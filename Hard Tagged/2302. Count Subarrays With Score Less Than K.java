// 3ms runtime Beats 100%

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum=0, count=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum*(i-j+1)>=k){
                sum-=nums[j++];
            }
            count+=(i-j+1);
        }
        return count;
    }
}
