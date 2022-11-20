class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
               break;
        }
        if(i<0){
            reverse(nums,0,nums.length-1);
        }
        else{
            int j=0;
            for(j=nums.length-1;j>=0;j--)
            {
                if(nums[j]>nums[i])
                    break;
            }
            swap(nums,i,j);
            reverse(nums,i+1,nums.length-1);
        }
    }
    
    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    private void reverse(int[] nums,int i,int j)
    {
        while(i<j) 
            swap(nums,i++,j--);
    }
}
