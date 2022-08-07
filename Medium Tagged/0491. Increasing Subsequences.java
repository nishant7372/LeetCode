class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<ArrayList<Integer>> a = new HashSet<ArrayList<Integer>>();
        List<List<Integer>> b = new ArrayList<List<Integer>>();
        generate(a,new ArrayList<Integer>(),0,nums);
        for(ArrayList<Integer> x:a)
            b.add(x);
        return b;
    }
    private void generate(Set<ArrayList<Integer>> a,ArrayList<Integer> temp,int index,int[] nums)
    {
        if(temp.size()>1)
        a.add(new ArrayList<Integer>(temp));
        for(int i=index;i<nums.length;i++)
        {
            if(temp.size()<nums.length && (temp.size()==0||temp.get(temp.size()-1)<=nums[i]))
            {
            temp.add(nums[i]);
            generate(a,temp,i+1,nums);
            temp.remove(temp.size()-1);
            }
        }
    }
}
