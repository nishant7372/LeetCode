class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int count=0;
        int[] a = new int[1001];
        //mark prime factors of all elements of nums using hashtable(a)
        for(int x:nums){
            primeFactors(x,a);
        }

        //counting all distinct prime factors
        for(int x:a){
            if(x==1)
                count++;
        }
        return count;
    }
    
    private void primeFactors(int x,int[] a)
    {
        int root = (int)Math.sqrt(x);
        for (int i=2; i<=root; i++) {
            while (x%i == 0) {
                x/=i;
                a[i]=1;
            }
        }

        if(x>=2)
            a[x]=1;
    }
    
}
