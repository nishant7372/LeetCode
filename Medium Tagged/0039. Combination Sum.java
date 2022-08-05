class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<ArrayList<Integer>> a = new HashSet<ArrayList<Integer>>();
        List<List<Integer>> b = new ArrayList<List<Integer>>();
        generate(candidates,target,a,new ArrayList<Integer>(),0);
        for(ArrayList<Integer> x:a)
            b.add(x);
        return b;
    }
    
    int index=0;
    int prev=0;
    private void generate(int[] nums,int target,Set<ArrayList<Integer>> a,ArrayList<Integer> list,int sum)
    {
        if(sum>=target)
        {
        if(sum==target)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            Collections.sort(temp);
            a.add(temp);
        }
        else
            index++;
        return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if (nums[i]+sum > target) {
            break;
            }
            list.add(nums[i]);
            generate(nums,target,a,list,sum+nums[i]);
            list.remove(list.size()-1);
        }
        if(list.size()==1)
        {
            prev++;
            index=prev;
        }
        else
            index=prev+1;
    }
}
