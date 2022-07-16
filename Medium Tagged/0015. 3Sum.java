class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
            
            List<Integer> temp;
            int j=1;
            int k=nums.length-1;
            while(j<k)
            {
               if(nums[j]+nums[k]>-nums[0])
                   k--;
               else if(nums[j]+nums[k]<-nums[0])
                   j++;
               else if(nums[j]+nums[k]==-nums[0])
               {
                   temp = new ArrayList<Integer>();
                   temp.add(nums[0]);
                   temp.add(nums[j]);
                   temp.add(nums[k]);
            
                   if(notPresent(temp,res))
                   res.add(temp);
                   
                   j++; 
               } 
            }
        
        for(int i=1;i<nums.length-2;i++)
        {
            if(nums[i]>0)
                break;
            
            if(nums[i]!=nums[i-1])
            {
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
               if(nums[j]+nums[k]>-nums[i])
                   k--;
               else if(nums[j]+nums[k]<-nums[i])
                   j++;
               else if(nums[j]+nums[k]==-nums[i])
               {
                   temp = new ArrayList<Integer>();
                   temp.add(nums[i]);
                   temp.add(nums[j]);
                   temp.add(nums[k]);
                   
                    if(notPresent(temp,res))
                   res.add(temp);
                   
                   j++; 
               } 
            }
            }
        }
        return res;
    }

    private boolean notPresent(List<Integer> a, List<List<Integer>> res)
    {
        if(res.size()==0)
            return true;
        if(res.get(res.size()-1).equals(a))
            return false;
        return true;
    }
}
