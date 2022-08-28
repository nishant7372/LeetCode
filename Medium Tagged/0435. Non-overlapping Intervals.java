class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,new ArrayComparator());
        int end = intervals[0][1];
        int c=1;
       for(int i=1;i<intervals.length;i++){
           if(intervals[i][0]>=end){
               end=intervals[i][1];
               c++;
           }
       }
       return intervals.length-c;
    }
}

class ArrayComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] a,int[] b){
        return a[1]-b[1];
    }    
}
