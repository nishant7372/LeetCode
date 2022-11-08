// Method 1 - Sorting

class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        if(arr[2]>arr[1]+arr[0])
            return arr[0]+arr[1];
        int sum = a+b+c;
        return sum/2;
    }
}

// Method 2 - Priority Queue
class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e2,e1));
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int sum=0;
        while(pq.size()>1)
        {
            int a1 = pq.remove();
            int a2 = pq.remove();
            sum++;
            if(a1>1)
            pq.add(a1-1);
            if(a2>1)
            pq.add(a2-1);
        }
        return sum;
    }
}
