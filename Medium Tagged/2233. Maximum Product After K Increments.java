class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x:nums)
            pq.add(x);
        
        Integer a=null;
        while(k-->0)
        {
            if(a==null)
            a = pq.remove();
            a++;
            if(!pq.isEmpty() && a>pq.peek()){
                pq.add(a);
                a=null;
            }
        }
        if(a!=null)
            pq.add(a);
        long res=1;
        int mod = 1000000007;
        Iterator pqIter = pq.iterator();
        
        while(pqIter.hasNext())
        {
            int b = (int)pqIter.next();
            res=(res*b)%mod;
        }
        return (int)res;
    }
}
