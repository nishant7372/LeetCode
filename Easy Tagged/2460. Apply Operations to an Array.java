class Solution {
    public int[] applyOperations(int[] nums) {
        boolean flag = true;
        while(flag)
        {
            flag = false;
            
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[i+1] && nums[i]!=0)
                {
                    flag = true;
                    nums[i]*=2;
                    nums[i+1]=0;
                }
            }
        }
        
        int k=0;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
                res[k++]=nums[i];
        }
        return res;
    }
}
