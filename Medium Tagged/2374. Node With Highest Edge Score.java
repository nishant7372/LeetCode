class Solution {
    public int edgeScore(int[] edges) {
        long[] a = new long[edges.length];
        int max=0;
        for(int i=0;i<edges.length;i++){
            a[edges[i]]+=i;
            if(a[edges[i]]>a[max])
                max=edges[i];
            else if(a[edges[i]]==a[max] && edges[i]<max)
                max=edges[i];
        }
       
        return max;
    
    }
}
