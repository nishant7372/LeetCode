class DataStream {

    private ArrayList<Integer> stream;
    private int count, value, k;
    
    public DataStream(int value, int k) {
        stream = new ArrayList<Integer>();
        this.count=0;
        this.k=k;
        this.value=value;
    }
    
    public boolean consec(int num) {
        stream.add(num);
        if(num==value)
            count++;
        else
            count=0;
        return count>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
