class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String,Long> map= new HashMap<>();
        
        int i=0;
        long max=0;
        for(String s:creators)
        {
            map.put(s,map.getOrDefault(s,0L)+views[i]);
            if(map.get(s)>max)
            {
                max=map.get(s);
            }
            i++;
        }
        
        ArrayList<String> keys = new ArrayList<String>();
        for(String s:map.keySet())
        {
            if(map.get(s)==max)
            {
               keys.add(s);
            }
        }
        Map<String,Pair<String,Integer>> map2 = new HashMap<>();
        
        for(i=0;i<creators.length;i++)
        {
            if(map2.get(creators[i])==null){
                map2.put(creators[i],new Pair<String,Integer>(ids[i],views[i]));
            }
            
            else {
                Pair<String,Integer> p = map2.get(creators[i]);
                if(p.getValue()<views[i])
                {
                    map2.put(creators[i],new Pair<String,Integer>(ids[i],views[i]));
                }
                else if(p.getValue()==views[i] && p.getKey().compareTo(ids[i])==1)
                map2.put(creators[i],new Pair<String,Integer>(ids[i],views[i]));
            }
            
        }
        
        List<List<String>> res = new ArrayList<>();
        for(String s:keys)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(s);
            temp.add(map2.get(s).getKey());
            res.add(temp);
            
        }
        return res;
        
    }
}
