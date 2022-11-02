class Solution {
    public long numberOfWeeks(int[] milestones) {
        long max=0;
        long sum=0;
        for(int x:milestones)
        {
            if(x>max)
                max=x;
            sum+=x;
        }
        
        sum-=max;
        if(max>sum)
            return 2*sum+1;
        return sum+max;
    }
}
