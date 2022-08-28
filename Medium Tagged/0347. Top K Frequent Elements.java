class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max=-10001;
        int min=10001;
        for(int x:nums)
        {
            if(x<min)
                min=x;
            if(x>max)
                max=x;
        }
        min=Math.abs(min);
        int[] a = new int[min+max+1];
        for(int x:nums)
            a[x+min]++;

      Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        
      for(int i=0;i<a.length;i++)
      {
          if(a[i]>0){
          if(map.get(a[i])==null)
          {
              ArrayList<Integer> temp = new ArrayList<Integer>();
              temp.add(i-min);
              map.put(a[i],temp);
          }
          else
              map.get(a[i]).add(i-min);
          }
      }
        List<Integer> freq = new ArrayList<>(map.keySet());
        Collections.sort(freq,Collections.reverseOrder());
        
        int index=0;
        int[] res = new int[k];
        for(int ele:freq)
        {
            for(int x:map.get(ele))
            {
                 res[index++]=x;
                 if(index==k)
                     break;
            }
            if(index==k)
                break;
        }
        return res;
    }
}
