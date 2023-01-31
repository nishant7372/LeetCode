// Method 1 --> LinkedList

class LFUCache {
    Map<Integer,LinkedList<Integer>> map;  // count --> list of keys
    Map<Integer,Integer> countMap;  // key --> count
    Map<Integer,Integer> valueMap;  // key --> value
    int available, maxCapacity;
    public LFUCache(int capacity) {
        this.map = new TreeMap<>();
        this.countMap = new HashMap<>();
        this.valueMap = new HashMap<>();
        this.available=capacity;
        this.maxCapacity = capacity;
    }
    
    public int get(int key) {
        if(maxCapacity==0 || valueMap.get(key)==null)
           return -1;
           
        int count = countMap.get(key)+1; //get newCount for key
        countMap.put(key,count); //update key-newCount to countMap

        LinkedList list = map.get(count-1);
        list.remove(Integer.valueOf(key)); // remove key from prevCount
        if(list.isEmpty())  
            map.remove(count-1); // remove empty list from map 

        if(map.get(count)==null)
           map.put(count,new LinkedList<Integer>());
        map.get(count).add(key); // add key to new Count list

        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(maxCapacity==0)
           return;
        int count = countMap.getOrDefault(key,0)+1; //get newCount for key
        countMap.put(key,count); // update/add key-newCount to countMap

        if(count==1 && available==0){
            int removedKey = map.get(map.keySet().iterator().next()).remove(); //remove LFU LRU Key from map
            valueMap.remove(removedKey); // remove LFU LRU Key from valueMap
            countMap.remove(removedKey); // remove LFU LRU Key from countMap
            available++;
        }

        if(count!=1){
            LinkedList list = map.get(count-1);
            list.remove(Integer.valueOf(key)); // remove key from prevCount
            if(list.isEmpty())  
               map.remove(count-1); // remove empty list from map 
        }

        if(map.get(count)==null)
           map.put(count,new LinkedList<Integer>());
        map.get(count).add(key); // add key to newCount list
        valueMap.put(key,value); // upadate/add key-value in valueMap

        if(count==1)
           available--; //decreasing capacity only when new key is introduced
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
// Method 2 --> ArrayList

class LFUCache {
    Map<Integer,ArrayList<Integer>> map;  // count --> list of keys
    Map<Integer,Integer> countMap;  // key --> count
    Map<Integer,Integer> valueMap;  // key --> value
    int available, maxCapacity;
    public LFUCache(int capacity) {
        this.map = new TreeMap<>();
        this.countMap = new HashMap<>();
        this.valueMap = new HashMap<>();
        this.available=capacity;
        this.maxCapacity = capacity;
    }
    
    public int get(int key) {
        if(maxCapacity==0 || valueMap.get(key)==null)
           return -1;
           
        int count = countMap.get(key)+1; //get newCount for key
        countMap.put(key,count); //update key-newCount to countMap

        ArrayList list = map.get(count-1);
        list.remove(Integer.valueOf(key)); // remove key from prevCount
        if(list.isEmpty())  
            map.remove(count-1); // remove empty list from map 

        if(map.get(count)==null)
           map.put(count,new ArrayList<Integer>());
        map.get(count).add(key); // add key to new Count list

        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(maxCapacity==0)
           return;
        int count = countMap.getOrDefault(key,0)+1; //get newCount for key
        countMap.put(key,count); // update/add key-newCount to countMap

        if(count==1 && available==0){
            int removedKey = map.get(map.keySet().iterator().next()).remove(0); //remove LFU LRU Key from map
            valueMap.remove(removedKey); // remove LFU LRU Key from valueMap
            countMap.remove(removedKey); // remove LFU LRU Key from countMap
            available++;
        }

        if(count!=1){
            ArrayList list = map.get(count-1);
            list.remove(Integer.valueOf(key)); // remove key from prevCount
            if(list.isEmpty())  
               map.remove(count-1); // remove empty list from map 
        }

        if(map.get(count)==null)
           map.put(count,new ArrayList<Integer>());
        map.get(count).add(key); // add key to newCount list
        valueMap.put(key,value); // upadate/add key-value in valueMap

        if(count==1)
           available--; //decreasing capacity only when new key is introduced
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
