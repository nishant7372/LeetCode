// 0ms runtime Beats 100%

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i=0;i<arr.length;i++){
            if(isRepeated(arr,i,i+m,k)){
                return true;
            }
        }
        return false;
    }

    private boolean isRepeated(int[] arr,int start,int end,int k){
        int idx=start;
        for(int i=start;i<arr.length;i++){
            if(arr[i]==arr[idx])
                idx++;
            else
                return false;
            if(idx==end){
                k--;
                idx=start;
                if(k==0)
                return true;
            }
        }
        return false;
    }
}
