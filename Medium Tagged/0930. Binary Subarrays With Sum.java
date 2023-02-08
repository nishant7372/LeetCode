class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return AtMostGoal(nums,goal)-AtMostGoal(nums,goal-1);
    }

    private int AtMostGoal(int[] nums,int goal){
        if(goal<0)
           return 0;
        int j=0, sum=0, count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>goal){
                sum-=nums[j++];
            }
            count+=i-j+1;
        }
        return count;
    }
}
