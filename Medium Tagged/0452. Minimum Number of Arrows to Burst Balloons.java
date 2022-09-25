class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a, b) -> Integer.compare(a[1],b[1]));
        int arrows=0;
        for(int i=0;i<points.length;i++)
        {
            int j=i+1;
            while(j<points.length&&points[j][0]<=points[i][1]){
                j++;
            }
            arrows++;
            i=j-1;
        }
        return arrows;
    }
}
