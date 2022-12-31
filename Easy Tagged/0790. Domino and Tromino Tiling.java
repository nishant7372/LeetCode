class Solution {
    public int numTilings(int n) {
        int mod = 1000000007;
        if(n<=2){
            return n;
        }
        int[] a = new int[n+1];
        a[0]=a[1]=1;
        a[2]=2;
        for(int i=3;i<=n;i++){
            a[i] = ((a[i-1]*2)%mod+a[i-3])%mod;
        }
        return a[n];
    }
}
