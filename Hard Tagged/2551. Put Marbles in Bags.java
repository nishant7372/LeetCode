class Solution {
    public long putMarbles(int[] weights, int k) {
        long[] a = new long[weights.length-1];
        for(int i=0;i<weights.length-1;i++){
            a[i]=(long)weights[i]+weights[i+1];
        }
        
        Arrays.sort(a);
        long maxSum=0;
        long minSum=0;
        for(int i=0;i<k-1;i++){
            minSum+=a[i];
            maxSum+=a[a.length-1-i];
        }
        return maxSum-minSum;
    }
}
