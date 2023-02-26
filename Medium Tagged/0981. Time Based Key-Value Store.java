// Method 1 
// Beats 88.4% -> Single HashMap + Binary Search

class TimeMap {
    Map<String,ArrayList<Obj>> keyMap;  // key -> list(value,timestamp)
    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(keyMap.get(key)==null)
            keyMap.put(key,new ArrayList<>());
        keyMap.get(key).add(new Obj(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(keyMap.get(key)==null)
            return "";
        int idx = Collections.binarySearch(keyMap.get(key),new Obj("", timestamp), (o1,o2) -> Integer.compare(o1.time, o2.time));
        if(idx<0)
            idx = -1*(idx+2);
        if(idx==-1)
            return "";
        return keyMap.get(key).get(idx).value;
    }
}

class Obj{
    String value;
    int time;
    public Obj(String value, int timestamp){
        this.value = value;
        this.time = timestamp;
    }
}

// Method 2
// Beats 88.4% -> Two HashMap + Binary Search

class TimeMap {
    Map<String,ArrayList<Integer>> keyMap;  // key -> list(timestamp)
    Map<Integer,String> valueMap;  // timestamp -> value
    public TimeMap() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(keyMap.get(key)==null){
            keyMap.put(key,new ArrayList<>());
        }
        keyMap.get(key).add(timestamp);
        valueMap.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(keyMap.get(key)==null)
            return "";
        int idx = Collections.binarySearch(keyMap.get(key),timestamp);
        if(idx<0)
            idx = -1*(idx+2);
        if(idx==-1)
            return "";
        return valueMap.get(keyMap.get(key).get(idx));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
