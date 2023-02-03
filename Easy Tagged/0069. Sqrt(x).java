// Beats 100% 1ms runtime (Binary Search)

class Solution {
    public int mySqrt(int x) {
        int i=1;
        int j=x;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(mid==x/mid)
                return mid;
            else if(mid<x/mid)
                i=mid+1;
            else
                j=mid-1;
        }
        return j;
    }
}

// Beats 100% 1ms runtime (Math.sqrt() method)

class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}
