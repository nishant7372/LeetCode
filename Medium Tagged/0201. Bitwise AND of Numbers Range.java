// Beats 99.9%

class Solution {
    public int rangeBitwiseAnd(int l, int r) {
        int c=0;
        while(l!=r){
            l>>=1;
            r>>=1;
            c++;
        }
        return l<<c;
    }
}
