// 3ms runtime Beats 72%
// Ternary Search

class Solution {
    public int findBestValue(int[] arr, int target) {
        // min value of value can be 0
        // max value of value can be max(arr)
        // ternary search -> find mid1 and mid2, divide array into three parts
 
        int i=0, j=0;
        for(int x:arr){
            j=Math.max(j,x);
        }
        
        while(i<=j){
            int mid1 = i+(j-i)/3, mid2 = j-(j-i)/3;
            long sum1=0, sum2=0;
            for(int x:arr){
                sum1+=Math.min(x,mid1);
                sum2+=Math.min(x,mid2);
            }
            if(sum2<=target){
                i=mid2+1;
            }
            else if(sum1>=target){
                j=mid1-1;
            }
            else{
                i=mid1+1;
                j=mid2-1;
            }
        }
        // answer is either i or j
        long sum1=0, sum2=0;
        for(int x:arr){
            sum1+=Math.min(x,i);
            sum2+=Math.min(x,j);
        }
        return Math.abs(sum1-target)<Math.abs(sum2-target)? i:j;
    }
}
