class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = -1;
        int second = -1;
        for(int x:cost)
        {
            if(first==-1)
                first=x;
            else if(second==-1)
                second=x;
            else{
            int res =Math.min(first,second)+x;
            first=second;
            second=res;
            }
        }
        
        return Math.min(first,second);
    }
}
