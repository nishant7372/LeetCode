// Beats 100% 0ms runtime 

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        for(int i=0;i<points.length-1;i++)
        {
            time+=calc(points[i],points[i+1]);
        }
        return time;
    }
    
    private int calc(int[] a,int[] b)
    {
       int x = Math.abs(a[0]-b[0]), y = Math.abs(a[1]-b[1]);
       return Math.min(x,y) + Math.abs(x-y);
    }
}
