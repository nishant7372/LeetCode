class Solution {
    public int countPrimeSetBits(int left, int right) {
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23};
        int[] a = new int[23];
        for(int i=left;i<=right;i++)
        {
            int c = 0;
            int n = i;
            while (n > 0) {
               c += n & 1;
               n >>= 1;
            }
            a[c]++;
        }
        int m=0;
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            if(i==primes[j])
            {
                m+=a[i];
                j++;
            }
        }
        return m;
    }
}
