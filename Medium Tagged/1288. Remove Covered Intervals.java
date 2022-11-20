class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]==b[0]? Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));
        int end = intervals[0][1];
        int c=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][1]<=end)
                c++;
            else
                end=intervals[i][1];
        }
        return intervals.length-c;
    }
}
