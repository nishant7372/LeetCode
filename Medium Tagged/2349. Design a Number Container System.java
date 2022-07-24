class NumberContainers {
    Map<Integer,Integer> map;
    Map<Integer,Map<Integer,Integer>> map2;
    public NumberContainers() {
        map=new HashMap<>();
        map2=new HashMap<>();
    }
    
    public void change(int index, int number) {
        int a=0;
        if(map.get(index)!=null)
            a=map.get(index);
        map.put(index,number);
        
        if(a!=0)
        map2.get(a).remove(index);
        if(map2.get(number)==null)
        {
            Map<Integer,Integer> map3 = new TreeMap<>();
            map3.put(index,null);
            map2.put(number,map3);
        }
        else
        map2.get(number).put(index,null);
    }
    
    public int find(int number) {
        if(map2.get(number)==null||map2.get(number).size()==0)
            return -1;
        for(int key:map2.get(number).keySet())
            return key;
        return 0;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
