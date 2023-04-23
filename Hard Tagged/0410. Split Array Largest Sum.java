// Beats 100%

class Solution {
    public int splitArray(int[] nums, int k) {
        int max=0, sum=0;
        for(int x:nums){
            max=Math.max(max,x);
            sum+=x;
        }
        int i=max, j=sum; 

        while(i<=j){
            int mid = (i+j)/2;

            if(canSplitintoK(nums,k,mid)){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }


    private boolean canSplitintoK(int[] nums,int k,int target){
        int sum=0;
        int split=1;
        for(int x:nums){
            sum+=x;
            if(sum>target){
                sum=x;
                split++;
            }
        }
        return split<=k;
    }
}
