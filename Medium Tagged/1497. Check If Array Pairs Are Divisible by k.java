// Method 1 --> 5ms runtime Beats 98.66%
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] a = new int[k+1];

        for(int x:arr){
            a[((x%k)+k)%k]++;   
        }
        for(int i=1;i<k;i++){
            if(a[i]!=a[k-i])
               return false;
        }
        return a[0]%2==0;
    }
}


// Method 2 --> 8ms runtime Beats 70.6%

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] a = new int[k+1];

        for(int x:arr){
            int rem = ((x%k)+k)%k;
            if(a[k-rem]!=0){
                a[k-rem]--;
            }
            else if(rem==0 && a[0]!=0){
                a[0]--;
            }
            else
                a[rem]++;
        }
        for(int x:a){
            if(x>0)
             return false;
        }
        return true;
    }
}
