// 15ms runtime, Beats 85%
// Sorting

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = capacity[i]-rocks[i];
        }
        
        Arrays.sort(a);
        int c=0;

        for(int x:a)
        {
            additionalRocks-=x;
            if(additionalRocks<0)
              return c;
            c++;
        }
        return c;
    }
}
