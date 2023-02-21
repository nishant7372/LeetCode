// 0ms runtime, Beats 100%
// Bit Manipulation

class Solution {
    // removing 01111.... by adding 1 making it 10000... Operation count -> 2
    // removing ....00001 by removing last bit. Operation count -> 1
    public int minOperations(int n) {
        int res=0;
        while(n>0){
            // if last two bits are set
            if((n&3)==3){
                n++; // adding 1 to n
                res++;
            }
            else{
                res+=(n&1);
                n>>=1; // right shift by 1 bit
            }
        }
        return res;
    }
}
