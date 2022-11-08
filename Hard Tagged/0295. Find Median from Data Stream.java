class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty())
            max.add(num);
        else if(max.peek()>=num)
            max.add(num);
        else
            min.add(num);
        
        if(max.size()-min.size()>1)
            min.add(max.remove());
        if(min.size()>max.size())
            max.add(min.remove());
    }
    
    public double findMedian() {
        if(min.size()==max.size())
            return ((double)(min.peek()+max.peek()))/2;
        else
            return (double)max.peek();
    }
}
