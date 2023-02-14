// 18ms runtime, Beats 80% 
// Binary Search 


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=1, j=0;
        for(int x:piles)
            j=Math.max(x,j);
        while(i<=j){
            int mid = (i+j)/2;
            long time=0;
            for(int x:piles){
                time= time + (x%mid==0? x/mid: (x/mid)+1);
            }
            if(h>=time)
                j=mid-1;
            else
                i=mid+1;
        }
        return i;
    }
}
