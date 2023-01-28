// Method 1 -->  Using Sorting with Comparator 
// 33ms runtime Beats 77%

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(x,y) -> Integer.compare((x[0]*x[0]+x[1]*x[1]),(y[0]*y[0]+y[1]*y[1])));
        return Arrays.copyOf(points,k);
    }
}


// Method 2 --> Using Priority Queue with Comparator
// Approach 1 --> Explicit Custom Comparator
// 42ms runtime Beats 55%

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new ArrayComparator());
        
        for(int[] x:points){
            queue.add(x);
        }
        int[][] res= new int[k][];
        for(int i=0;i<k;i++)
            res[i]=queue.remove();
        return res;
    }
}

class ArrayComparator implements Comparator<int[]> {
    public int compare(int[] x, int[] y) {
        if (x[0]*x[0]+x[1]*x[1] < y[0]*y[0]+y[1]*y[1]) {
            return -1;
        }
        if (x[0]*x[0]+x[1]*x[1] > y[0]*y[0]+y[1]*y[1]) {
            return 1;
        }
        return 0;
    }
}


// Method 2 --> Using Priority Queue with Comparator
// Approach 2 --> Inline Comparator
// 42ms runtime Beats 55%

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((x,y) -> Integer.compare((x[0]*x[0]+x[1]*x[1]),(y[0]*y[0]+y[1]*y[1])));
        
        for(int[] x:points){
            queue.add(x);
        }
        int[][] res= new int[k][];
        for(int i=0;i<k;i++)
            res[i]=queue.remove();
        return res;
    }
}
