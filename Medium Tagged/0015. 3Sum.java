// 38ms runtime 
// Without Set
// Beats 72%

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]>0)
                return res;
            
            if(i==0 || nums[i]!=nums[i-1])
            {
                int j=i+1, k=n-1;
                while(j<k)
                {
                    if(nums[j]+nums[k]>-nums[i])
                       k--;
                    else if(nums[j]+nums[k]<-nums[i])
                       j++;
                    else if(nums[j]+nums[k]==-nums[i])
                    {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                   
                        addIfNotPresent(temp,res);
                        j++; 
                    } 
                }
            }
        }
        return res;
    }

    private void addIfNotPresent(List<Integer> a, List<List<Integer>> res)
    {
        if(res.size()==0)
            res.add(a);
        else if(!res.get(res.size()-1).equals(a))
            res.add(a);
    }
}
