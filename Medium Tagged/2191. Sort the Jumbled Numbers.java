//Method 1
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        for(int x:nums)
        {
            int key = value(x,mapping);
            if(map.get(key)==null)
                map.put(key,new ArrayList<Integer>());
            map.get(key).add(x);
        }
        int i=0;
        for(int x:map.keySet())
        {
            for(int y:map.get(x)){
                nums[i++]=y;
            }
        }
        
        return nums;
    }
    
    private int value(int x,int[] mapping)
    {
        StringBuffer sb = new StringBuffer(x+"");
        
        for(int i=0;i<sb.length();i++)
        {
            sb.setCharAt(i,(char)(mapping[sb.charAt(i)-'0']+'0'));
        }
        return Integer.parseInt(sb.toString());
    }
}

//Method 2
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int x:nums)
        {
            int key = value(x,mapping);
            if(map.get(key)==null)
                map.put(key,new ArrayList<Integer>());
            map.get(key).add(x);
        }
        int i=0;
        
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(int x:keySet)
        {
            for(int y:map.get(x)){
                nums[i++]=y;
            }
        }
        
        return nums;
    }
    
    private int value(int x,int[] mapping)
    {
        StringBuffer sb = new StringBuffer(x+"");
        
        for(int i=0;i<sb.length();i++)
        {
            sb.setCharAt(i,(char)(mapping[sb.charAt(i)-'0']+'0'));
        }
        return Integer.parseInt(sb.toString());
    }
}

//Method 3
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        for(int x:nums)
        {
            int key = value(x,mapping);
            if(map.get(key)==null)
                map.put(key,new ArrayList<Integer>());
            map.get(key).add(x);
        }
        int i=0;
        for(var entry:map.entrySet())
        {
            for(int y:entry.getValue()){
                nums[i++]=y;
            }
        }
        
        return nums;
    }
    
    private int value(int x,int[] mapping)
    {
        StringBuffer sb = new StringBuffer(x+"");
        
        for(int i=0;i<sb.length();i++)
        {
            sb.setCharAt(i,(char)(mapping[sb.charAt(i)-'0']+'0'));
        }
        return Integer.parseInt(sb.toString());
    }
}
