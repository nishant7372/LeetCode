class Solution {
    public int[] twoSum(int[] nums, int target) {
      int i=0;
      int j=nums.length-1;
      while(i!=nums.length-1)
      {
          j=nums.length-1;
       while(i<j)
       {
           if(nums[i]+nums[j]==target)
               return new int[]{i,j};
           j--;
       }
       i++;
      }
        return new int[]{};
    }
}
