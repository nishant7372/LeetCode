class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        generate(a,new ArrayList<Integer>(),0,nums);
        return a;
    }
    
    private void generate(List<List<Integer>> a,ArrayList<Integer> temp,int index,int[] nums)
    {
        a.add(new ArrayList<Integer>(temp));
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            generate(a,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
}
