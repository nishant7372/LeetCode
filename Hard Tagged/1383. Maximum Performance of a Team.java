class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }
        
        Arrays.sort(arr,new ArrayComparator());
        
        long sum = 0;
        long maxEfficiency = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] x:arr)
        {
            sum+=x[0];
            queue.add(x[0]);
            if(queue.size()>k)
            {
                sum-=queue.remove();
            }
            maxEfficiency=Math.max(maxEfficiency,sum*x[1]);
        }
        return (int)(maxEfficiency%1000000007);
    }
}

class ArrayComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b)
    {
        return Integer.compare(b[1],a[1]);
    }
}
