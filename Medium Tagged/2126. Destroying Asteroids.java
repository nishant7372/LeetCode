//Method 1 --> Sorting

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m=mass;
        Arrays.sort(asteroids);

        for(int x:asteroids)
        {
            if(x>m)
            return false;
            m+=x;
        }
        return true;
    }
}

//Method 2 --> Priority Queue

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long m=mass;
        for(int x:asteroids)
        queue.add(x);


        while(!queue.isEmpty())
        {
             PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());

            while(!queue.isEmpty() && queue.peek()>m){
                list.add(queue.remove());
            }

            if(queue.isEmpty())
                return false;

            for(int x:queue)
            m+=x;
            queue=list;
        }
        return true;
    }
}
