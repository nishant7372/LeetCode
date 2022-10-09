// Method 0 (Optimized) --> Counting-Sort
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        
        int[] a = new int[41];
        for(int x:candidates)
        a[x]=1;
       
        int i=0;
        int j=0;
        for(int x:a)
        {
            if(x==1)
            candidates[j++]=i;
            i++;
        }
        
        find(list,candidates,target,new ArrayList<Integer>(),0);
        return list;
    }
    
    
    private void find(List<List<Integer>> list,int[] candidates,int target,ArrayList<Integer> temp,int start)
    {
        if(target==0)
        {
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=start;i<candidates.length;i++)
        {
            if(target-candidates[i]>=0)
            {
                temp.add(candidates[i]);
                find(list,candidates,target-candidates[i],temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
}


// Method 1 (Optimized)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        
        Arrays.sort(candidates);
        
        find(list,candidates,target,new ArrayList<Integer>(),0);
        return list;
    }
    
    
    private void find(List<List<Integer>> list,int[] candidates,int target,ArrayList<Integer> temp,int start)
    {
        if(target==0)
        {
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=start;i<candidates.length;i++)
        {
            if(target-candidates[i]>=0)
            {
                temp.add(candidates[i]);
                find(list,candidates,target-candidates[i],temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
}

//Using set --> Method 2
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
