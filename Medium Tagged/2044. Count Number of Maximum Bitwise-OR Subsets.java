class Solution {
    private int c=0;
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int x:nums)
            max=max|x;
        generate(nums,0,0,max);
        return c;
    }
    
    private void generate(int[] nums,int index,int or,int max)
    {
        if(or==max)
            c++;
        for(int i=index;i<nums.length;i++)
            generate(nums,i+1,or|nums[i],max);
    }
}
