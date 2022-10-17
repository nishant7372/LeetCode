class Solution {
    public int twoEggDrop(int n) {
        int c=0;
        while(n>0)
            n-=++c;
        return c;
    }
}
