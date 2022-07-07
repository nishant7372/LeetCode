class Solution {
    public int mostFrequent(int[] nums, int key) {
       Map<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
          if(nums[i]==key&&i<nums.length-1)
          {
              if(map.get(nums[i+1])==null)
                  map.put(nums[i+1],1);
              else
                  map.put(nums[i+1],map.get(nums[i+1])+1);
          }
      }
          int maxKey=0;
          int maxVal=0;
      for (var entry : map.entrySet()) {
      if(entry.getValue()>maxVal)
      {
          maxVal=entry.getValue();
          maxKey=entry.getKey();
      }
      } 
        return maxKey;
    }
}
