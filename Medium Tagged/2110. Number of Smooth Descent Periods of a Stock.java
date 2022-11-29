class Solution {
    public long getDescentPeriods(int[] prices) {
        long c=1;
        int i=0;
        for(int j=1;j<prices.length;j++)
        {
            if(prices[j]!=prices[j-1]-1)
                i=j;
            c+=j-i+1;
        }
        return c;
    }
}
