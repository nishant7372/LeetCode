class Solution {
    public int addRungs(int[] rungs, int dist) {
        int c=(rungs[0]-0)/dist;
        if((rungs[0]-0)%dist==0)
        c--;
        for(int i=1;i<rungs.length;i++)
        {
            c+=(rungs[i]-rungs[i-1])/dist;
            if((rungs[i]-rungs[i-1])%dist==0)
            c--;
        }
        return c;
    }
}
