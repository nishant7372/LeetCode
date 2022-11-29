class Solution {
    public int hammingDistance(int x, int y) {
        return check(x,y,0);
    }
    
    private int check(int x,int y,int c)
    {
        if(x==0 && y==0)
            return c;
        if(x%2!=y%2)
            c++;
        return check(x/2,y/2,c);
    }
}
