class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
     double x = Math.log10(n)/Math.log10(2);
        if(x-(int)x>0)
          return false;
        return true;
    }
}
