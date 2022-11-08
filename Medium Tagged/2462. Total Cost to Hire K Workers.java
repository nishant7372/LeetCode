class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0]? Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        
        for(int i=0;i<candidates;i++)
        {
            pq.add(new int[]{costs[i],i});
        }
        for(int i=costs.length-1;i>Math.max(costs.length-1-candidates,candidates-1);i--)
        {
            pq.add(new int[]{costs[i],i});
        }
        
        int p1 = candidates;
        int p2 = costs.length-1-candidates;
        long sum=0;
        while(k-->0)
        {
            int[] curr = pq.remove();
            sum+=curr[0];
            if(p1<curr[1] && p1<=p2){
                pq.add(new int[]{costs[p2],p2});
                p2--;
            }
            else if(p1>curr[1] && p1<=p2){
                pq.add(new int[]{costs[p1],p1});
                p1++;
            }
        }
        return sum;
    }
}
