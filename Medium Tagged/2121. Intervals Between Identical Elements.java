// Beats 56% 110ms runtime

class Solution {
    public long[] getDistances(int[] arr) {
        int max=0;
        for(int x:arr)
            max = Math.max(x,max);

        long[][] a = new long[max+1][4];
    
        int i=0;
        for(int x:arr)
        {
            a[x][1]+=i++; // total sum of indices with value x
            a[x][3]++;    // no. of occurences of x in arr
        }
        
        long[] res = new long[arr.length];
        i=0;
        for(int x:arr)
        {
            a[x][1]-=i;  // sum of indices at right
            a[x][3]--;   // right freq
            res[i]=Math.abs(a[x][0]-i*a[x][2])+Math.abs(a[x][1]-i*a[x][3]);
            a[x][0]+=i++;  // sum of indices at left
            a[x][2]++;   // left freq
        }
        return res;
    }
}
