// 9ms runtime, Beats 95.5%
// Binary Search

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // min weight of ship can be max(weights) (needs each box to be completely transfered per day)
        // max weight of ship can be totalWeights of packages (when all transfered within one day)

        int i=0, j=0;
        for(int x:weights){
            i=Math.max(i,x);
            j+=x;
        }
        while(i<=j){
            int mid = (i+j)/2;
            int currdays = 1;
            int sum=0;
            for(int x:weights){
                sum+=x;
                if(sum>mid){
                    sum=x;
                    currdays++;
                }
            }

            if(currdays>days){
                i=mid+1;  // increasing the weight of ship when currdays>days
            }
            else{
                j=mid-1;  // reducing the weight of ship when currdays<=days
            }
        }
        return i;
    }
}
