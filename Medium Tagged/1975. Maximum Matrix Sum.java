// Greedy Solution --> 4ms runtime Faster than 96%
 
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg=0, min = Integer.MAX_VALUE;
        long sum=0;
        for(int[] row:matrix){
            for(int x:row){
                if(x<0)
                   neg++;
                min=Math.min(min,Math.abs(x));
                sum+=Math.abs(x);
            }
        }
        // when no. of negatives in matrix is even we can make all positive else there will be only one negative in matrix at last.
        // We can make smallest absolute number negative for maximizing the sum.
        return neg%2==0? sum: sum-2*min;
    }
}
