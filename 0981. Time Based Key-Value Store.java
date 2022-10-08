class TimeMap {
    Map<String,ArrayList<Integer>> map;
    Map<Integer,String> map2;
    public TimeMap() {
        map = new HashMap<String,ArrayList<Integer>>();
        map2 = new HashMap<Integer,String>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.get(key)==null){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(timestamp);
            map.put(key,temp);
        }
        else{
            map.get(key).add(timestamp);
        }
        map2.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key)==null)
            return "";
        ArrayList<Integer> list = map.get(key);
        int idx = Collections.binarySearch(list,timestamp);
        if(idx<0)
            idx = -1*(idx+2);
        if(idx==-1)
            return "";
        return map2.get(list.get(idx));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
