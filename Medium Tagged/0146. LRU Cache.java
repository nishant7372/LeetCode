// 86ms runtime Beats 37.29% (LinkedHashMap JAVA)

class LRUCache {
    Map<Integer,Integer> map;
    int cap;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.get(key)!=null){
            int res =  map.get(key);
            map.remove(key);
            map.put(key,res);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cap==0 && map.get(key)==null){
            map.remove(map.keySet().iterator().next());
            cap++;
        }
        if(map.get(key)!=null){
            map.remove(key);
            cap++;
        }
        map.put(key,value);
        cap--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
