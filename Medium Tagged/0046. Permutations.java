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


//Another Way
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] freq = new int[21];
        for(int x:nums)
            freq[x+10]++;
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        combine(nums,a,new ArrayList<Integer>(),freq,new int[21]);
        return a;
    }

    private void combine(int[] nums,List<List<Integer>> a,ArrayList<Integer> list,int[] freq,int[] freq1)
    {
        if(list.size()==nums.length)   
        {
            a.add(new ArrayList<Integer>(list));
            return;
        }
        for(int x:nums)
        {
            if(freq1[x+10]<freq[x+10])
            {
            freq1[x+10]++;
            list.add(x);
            combine(nums,a,list,freq,freq1);
            freq1[list.remove(list.size()-1)+10]--;
            }
        } 
    }
}
