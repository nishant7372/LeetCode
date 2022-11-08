class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>((a,b) -> Double.compare(b,a));
        
        double sum=0;
        for(int x:nums)
        {
            sum+=x;
            queue.add((double)x);
        }
        
        double reduced = 0.00;
        int c=0;
        while(reduced<sum/2)
        {
            double a = queue.remove();
            reduced+=a/2;
            queue.add(a/2);
            c++;
        }
        return c;
    }
}
