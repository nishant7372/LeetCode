class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int res1 = (Math.min(ay2,by2)-Math.max(ay1,by1));
        int res2 = (Math.min(ax2,bx2)-Math.max(ax1,bx1));
        
        if(res1<0 || res2<0)
            res1=0;
        
        return (Math.abs(ax1-ax2)*Math.abs(ay1-ay2)) + (Math.abs(bx1-bx2)*Math.abs(by1-by2)) - (res1*res2); 
    }
}
