class StockPrice {
    TreeMap<Integer,Integer> map, pMap;
    public StockPrice() {
        map = new TreeMap<>();
        pMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(map.get(timestamp)!=null){
            int p = map.get(timestamp);
            pMap.put(p,pMap.get(p)-1);
            if(pMap.get(p)==0)
                pMap.remove(p);
        }
        pMap.put(price,pMap.getOrDefault(price,0)+1);
        map.put(timestamp,price);
    }
    
    public int current() {
        return map.lastEntry().getValue();
    }
    
    public int maximum() {
        return pMap.lastKey();
    }
    
    public int minimum() {
        return pMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
