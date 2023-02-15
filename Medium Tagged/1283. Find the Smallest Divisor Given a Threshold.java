// 9ms runtime Beats 97%
// Binary Search

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // min value of divisor = `1
        // max value of divisor = (int)1e6

        int i=1, j=(int)1e6;

        while(i<=j){
            int mid = (i+j)/2;

            int sum=0;
            for(int x:nums){
                sum+=(x-1)/mid+1; // getting Math.ceil(x/mid)
            }

            if(sum>threshold){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return i;
    }
}
