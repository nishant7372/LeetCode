// Method 1 --> 6ms runtime Beats 94.64%

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23};
        int[] a = new int[23];
        for(int i=left;i<=right;i++){
            a[Integer.bitCount(i)]++;
        }
        int count=0;
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            if(i==primes[j]){
                count+=a[i];
                j++;
            }
        }
        return count;
    }
}

// Method 2 --> 13ms runtime Beats 69.20%

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

// Method 3 --> 138ms runtime Beats 18.53%

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23};
        int[] a = new int[23];
        for(int i=left;i<=right;i++)
        {
            int c = 0;
            int n = i;
            while (n > 0) {
                if(n%2==1)
                   c++;
                n/=2;
            }
            a[c]++;
        }
        int count=0;
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            if(i==primes[j]){
                count+=a[i];
                j++;
            }
        }
        return count;
    }
}

