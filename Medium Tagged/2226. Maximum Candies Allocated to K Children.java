// 13ms runtime Beats 98%
// Binary Search

class Solution {
    public int maximumCandies(int[] candies, long k) {
        // can give maximum (sum(candies))/k candies to each children, j=(sum(candies))/k
        // can give minimum 0 candy to each children, i=0;

        long sum=0;
        for(int x:candies){
            sum+=x;
        }
        int i=0, j=(int)(sum/k);
        while(i<=j){
            int mid = (i+j)/2;
            long child = 0;
            if(mid==0){
               child=(long)1e12;
            }
            else{
                for(int x:candies)
                    child+=x/mid;
            }

            if(child>=k)
               i=mid+1;
            else
               j=mid-1;
        }
        return Math.max(j,0);
    }
}
