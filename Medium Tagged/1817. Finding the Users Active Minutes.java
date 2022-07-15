class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] array = new int[k];
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<logs.length;i++)
        {
            if(map.get(logs[i][0])==null)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(logs[i][1]);
                map.put(logs[i][0],temp);
            }
            else
            {
                if(!map.get(logs[i][0]).contains(logs[i][1]))
                map.get(logs[i][0]).add(logs[i][1]);
            }
        }
        
        Map<Integer,Integer> map2 = new HashMap<>();
        for(var entry:map.entrySet())
        {
            if(map2.get(entry.getValue().size())==null)
            map2.put(entry.getValue().size(),1);
            else
            {
                map2.put(entry.getValue().size(),map2.get(entry.getValue().size())+1);
            }
        }
        
        for(var entry:map2.entrySet())
        {
            array[entry.getKey()-1]=entry.getValue();
        }
        return array;
    }
}
