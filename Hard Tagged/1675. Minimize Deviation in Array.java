// TreeSet
// Beats 90%

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        // maximizing each value
        for(int x:nums){
            set.add(x%2==0? x: x*2);
        }

        int minDev = Integer.MAX_VALUE;
        
        int max=0;
        while(max%2==0){
            max = set.last();
            int min = set.first();
            minDev = Math.min(minDev,max-min);
            set.pollLast();
            set.add(max/2);
        }
        return minDev;
   }
}

// PriorityQueue
// Beats 20%

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int min= Integer.MAX_VALUE;
        // maximizing each value
        for(int x:nums){
            if(x%2==0){
                q.add(x);
                min=Math.min(min,x);
            }
            else{
                q.add(x*2);
                min=Math.min(min,x*2);
            }
        }

        int minDev = Integer.MAX_VALUE;
        
        while(true){
            int max = q.peek();
            minDev = Math.min(minDev,max-min);
            if(max%2==0){
                q.remove();
                q.add(max/2);
                min=Math.min(min,max/2);
            }
            else
                break;
        }
        return minDev;
   }
}
