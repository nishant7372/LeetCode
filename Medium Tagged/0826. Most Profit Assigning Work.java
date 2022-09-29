//Method 1 - Counting-Sort & Prefix-Sum (Faster than 95percent)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int max=0;
        for(int x:difficulty)
        {
            if(x>max)
                max=x;
        }
        
        int[] a = new int[max+1];
        
        for(int i=0;i<difficulty.length;i++)
        {
            if(a[difficulty[i]]<profit[i])
            a[difficulty[i]] = profit[i];
        }
        
        max=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
                max=a[i];
            else
                a[i]=max;
        }
        
        int sum=0;
        for(int x:worker)
        {
            if(x>=a.length)
                x=a.length-1;
            sum+=a[x];
        }
        return sum;
    }
}
//Method 2 - Binary Search using TreeMap
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer,Integer> map  = new TreeMap<>();
       
        for(int i=0;i<difficulty.length;i++)
        {
            if(map.get(difficulty[i])==null || map.get(difficulty[i])<profit[i])
            map.put(difficulty[i],profit[i]);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        
        int max=0;
        for(var entry: map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(value>max)
            {
                max = value;
            }
            else{
                map.put(key,max);
            }
        }
        
        int sum=0;
        for(int x:worker)
        {
            int idx = Collections.binarySearch(keys,x);
            if(idx<0)
            {
                idx = -1*(idx+1);
                idx--;
            }
            if(idx>=0)
            sum+=map.get(keys.get(idx));
        }
        return sum;
    }
}
