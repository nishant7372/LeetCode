//Method 1 -> Optimized using HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,int[]> map = new HashMap<>();
        
       for(int i=0;i<nums.length;i++)
       {
           if(map.get(nums[i])==null){
               int[] temp = new int[]{i,-1};
               map.put(nums[i],temp);
           }
           else
               map.get(nums[i])[1]=i;
       }
        
        for(int x:map.keySet())
        {
            if(x==target-x)
            {
                return new int[]{map.get(x)[0],map.get(x)[1]};
            }
            else if(map.get(target-x)!=null)
            {
                return new int[]{map.get(x)[0],map.get(target-x)[0]};
            }
        }
        return new int[]{-1,-1};
    }
}

//Method 2 -> Brute Force
class Solution {
    public int[] twoSum(int[] nums, int target) {
      int i=0;
      int j=nums.length-1;
      while(i!=nums.length-1)
      {
          j=nums.length-1;
       while(i<j)
       {
           if(nums[i]+nums[j]==target)
               return new int[]{i,j};
           j--;
       }
       i++;
      }
        return new int[]{};
    }
}
