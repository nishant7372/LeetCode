class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        generate(candidates,target,a,new ArrayList<Integer>(),0,0);
        return a;
    }

    private void generate(int[] nums,int target,List<List<Integer>> a,ArrayList<Integer> list,int sum,int index)
    {
        if(sum>=target)
        {
        if(sum==target)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            if(a.indexOf(temp)==-1)
            a.add(temp);
        }
        return;
        }
        for(int i=index;i<nums.length;i++)
        {
        if (i > index && nums[i - 1] == nums[i]) {
            continue;
        }
        if (nums[i]+sum > target) {
            break;
        }
        list.add(nums[i]);
        generate(nums,target,a,list,sum+nums[i],i+1);
        list.remove(list.size()-1);
        }
    }
}
