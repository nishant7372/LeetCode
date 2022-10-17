class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;  // maxLength
        int zero=0;  //zeroes-count
        int j=-1;     //lower bound for window
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0){
                zero++;
            }
            if(zero>k){
                max = Math.max(max,i-j-1);
                while(nums[++j]!=0);
                zero--;
            }    
        }
        return Math.max(max,nums.length-j-1);
    }
}
