class MyCalendar {
     List<List<Integer>> a ;
    public MyCalendar() {
        a = new ArrayList<List<Integer>>(); 
    }
    
    public boolean book(int start, int end) {
        for(int i=0;i<a.size();i++)
        {
            int start1 = a.get(i).get(0);
            int end1 = a.get(i).get(1);
            if(start>=start1&&start<end1)
                return false;
            if(end>start1&&end<=end1)
                return false;
            if(start<start1&&(end>start1&&end<=end1))
                return false;
            if(end>end1&&(start>=start1&&start<end1))
                return false;
            if(start<=start1&&end>=end1)
                return false;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(start);
        list.add(end);
        a.add(list);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
