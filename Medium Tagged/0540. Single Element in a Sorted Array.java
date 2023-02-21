// 0ms runtime, Beats 100% 
// Time complexity -> log(n)
// Space Complexity -> O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int i=0, j=nums.length-1;
        
        while(i<=j){
            int mid = (i+j)/2;
            if(mid%2==0){
                // last Index will always be even -> length of nums is odd
                if(mid==nums.length-1){ 
                   return nums[mid];
                }
                if(nums[mid]==nums[mid+1]){
                   i=mid+1;
                }
                else{
                   j=mid-1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){
                   j=mid-1;
                }
                else{
                   i=mid+1;
                }
            }
        }
        return nums[i];
    }
}
