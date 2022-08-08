class Solution {
    public void sortColors(int[] nums) {
        int index=0;
        int i=0;
        int j=nums.length-1;
        while(index<=j)
        {
            while(nums[index]==0||nums[index]==2){
            if(nums[index]==0){
                swap(nums,index,i++);
            }
            if(nums[index]==2){
                swap(nums,index,j--);
            }
            if(index<i||index>j)
                break;
            }
            index++;
        }
    }
    
    private void swap(int[] nums,int i,int j)
    {
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
