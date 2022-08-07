class Solution {
    private int sum=0;
    public int subsetXORSum(int[] nums) {
        generate(nums,new ArrayList<Integer>(),0,0,0);
        return sum;
    }
    
    
    private void generate(int[] nums,ArrayList<Integer> a,int index,int xor,int c)
    {
        sum+=xor;
        for(int i=index;i<nums.length;i++)
            generate(nums,a,i+1,xor^nums[i],c+1);
    }
}
