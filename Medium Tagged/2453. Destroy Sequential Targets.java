class Solution {
    public int destroyTargets(int[] nums, int space) {
        int[] a = new int[nums.length];
        
        int i=0;
        for(int x:nums)
        {
            a[i++]=x%space;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int x:a)
        {
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)>max)
                max=map.get(x);
        }
        
        Set<Integer> keys = new HashSet<>();
        
        for(int x:map.keySet())
        {
            if(map.get(x)==max)
                keys.add(x);
        }
        
        int min=Integer.MAX_VALUE;
        for(i=0;i<nums.length;i++)
        {
            if(keys.contains(a[i])&&nums[i]<min)
                min=nums[i];
        }
        return min;
    }
}
