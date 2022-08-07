class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        generate(a,new ArrayList<Integer>(),0,nums);
        return a;
    }
    
    private void generate(List<List<Integer>> a,ArrayList<Integer> temp,int index,int[] nums)
    {
        ArrayList<Integer> b = new ArrayList<Integer>(temp);
        Collections.sort(b);
        if(a.indexOf(b)==-1)
        a.add(b);
        for(int i=index;i<nums.length;i++)
        {
            if(temp.size()<nums.length)
            {
            temp.add(nums[i]);
            generate(a,temp,i+1,nums);
            temp.remove(temp.size()-1);
            }
        }
    }
}
