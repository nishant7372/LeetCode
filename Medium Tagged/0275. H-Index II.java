class Solution {
    public int hIndex(int[] citations) {
        int start=0;
        int end=citations.length-1;
        int n = end+1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(citations[mid]<n-mid){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return n-start;
    }
}
