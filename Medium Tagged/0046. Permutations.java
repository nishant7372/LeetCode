class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        combine(nums,a,new ArrayList<Integer>());
        return a;
    }
    
    private void combine(int[] nums,List<List<Integer>> a,ArrayList<Integer> list)
    {
        if(list.size()==nums.length)   
        {
            a.add(new ArrayList<Integer>(list));
            return;
        }
        for(int x:nums)
        {
            if(list.indexOf(x)==-1)
            {
            list.add(x);
            combine(nums,a,list);
            list.remove(list.size()-1);
            }
        }
    }
}
