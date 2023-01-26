//Approach 1 --> Priority Queue (Min-Heap)

class SeatManager {
    PriorityQueue<Integer> pq;
    int unreserved=1;
    public SeatManager(int n) {
        pq=new PriorityQueue<>();
    }
    
    public int reserve() {
        if(!pq.isEmpty())
           return pq.remove();
        return unreserved++;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

//Approach 2 --> TreeSet (Ascending) & Iterator 

class SeatManager {
    Set<Integer> set;
    int avail=1;
    public SeatManager(int n) {
        set = new TreeSet<>();
    }
    
    public int reserve() {
        if(!set.isEmpty()){
            int seat = set.iterator().next();
            set.remove(seat);
            return seat;
        }
        return avail++;
    }
    
    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}


//Approach 3 --> TreeMap (Ascending) & Iterator 

class SeatManager {
    private Map<Integer,Integer> map;
    int avail=1;
    public SeatManager(int n) {
        map=new TreeMap();
    }
    
    public int reserve() {
         if(!set.isEmpty()){
            int seat = map.iterator().next();
            map.remove(seat);
            return seat;
        }
        return avail++;
    }
    
    public void unreserve(int seatNumber) {
        map.put(seatNumber,null);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
 
