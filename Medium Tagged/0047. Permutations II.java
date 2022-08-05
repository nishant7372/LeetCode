class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] freq = new int[21];
        List<Integer> unique = new ArrayList<>();
        for(int x:nums)
        {
            freq[x+10]++;
        }
        for(int i=0;i<21;i++)
        {
            if(freq[i]>0)
                unique.add(i-10);
        }
        
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        combine(nums,a,new ArrayList<Integer>(),freq,unique);
        return a;
    }

    private void combine(int[] nums,List<List<Integer>> a,ArrayList<Integer> list,int[] freq,List<Integer> unique )
    {
        if(list.size()==nums.length)   
        {
            a.add(new ArrayList<Integer>(list));
            return;
        }
        for(int x:unique)
        {
            int count= freq[x+10];
            if(freq[x+10]==0)
            continue;
            
            freq[x+10]--;
            list.add(x);
            combine(nums,a,list,freq,unique);
            list.remove(list.size()-1);
            freq[x+10]=count;
        } 
    }
}


//Using HashSet
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] freq = new int[21];
        Set<Integer> set = new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
            freq[x+10]++;
        }
        
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        combine(nums,a,new ArrayList<Integer>(),freq,set);
        return a;
    }

    private void combine(int[] nums,List<List<Integer>> a,ArrayList<Integer> list,int[] freq,Set<Integer> set)
    {
        if(list.size()==nums.length)   
        {
            a.add(new ArrayList<Integer>(list));
            return;
        }
        for(int x:set)
        {
            int count= freq[x+10];
            if(freq[x+10]==0)
            continue;
            
            freq[x+10]--;
            list.add(x);
            combine(nums,a,list,freq,set);
            list.remove(list.size()-1);
            freq[x+10]=count;
        } 
    }
}
