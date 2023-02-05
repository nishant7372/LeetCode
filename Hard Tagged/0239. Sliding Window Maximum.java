// 31ms runtime --> Beats 91% O(n) Solution 

// We maintain a queue where each element is smaller than the previous element,
// and the first element always corresponds to the maximum element inside the window. 
// After each window move, we remove elements from the end of the queue until 
// the last queue element is greater than the new window element, or the queue becomes empty.
// We also remove the first queue element if it is not inside the window anymore.
// Finally, we add the new window element to the end of the queue.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        Deque<Integer> queue = new ArrayDeque<>();

        int max=Integer.MIN_VALUE;
      
        for(int i=0;i<k;i++){
            // remove elements smaller than nums[i] from the end of queue
            while(!queue.isEmpty() && nums[i]>queue.getLast()){
                queue.removeLast();
            }
            queue.add(nums[i]); // add nums[i] to queue
        }
        res[0]=queue.getFirst();
        for(int i=k;i<nums.length;i++){
            if(!queue.isEmpty() && queue.getFirst()==nums[i-k]){
                queue.removeFirst();
            }
            // remove elements smaller than nums[i] from the end of queue
            while(!queue.isEmpty() && nums[i]>queue.getLast()){
                queue.removeLast();
            }
            queue.add(nums[i]); // add nums[i] to queue
            res[i-k+1]=queue.getFirst(); 
        }
        return res;
    }
}


// 190ms runtime Beats 15% --> O(nlogn) Solution

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]-a[0]); // max Heap
        
        int[] res = new int[nums.length-k+1];

        for(int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        for(int i=k;i<nums.length;i++)
        {
            res[i-k]=queue.peek()[0];
            queue.add(new int[]{nums[i],i});
            
            while(!queue.isEmpty() && queue.peek()[1]<=i-k)
                queue.remove();
        }
        res[res.length-1]=queue.peek()[0];
        return res;
    }
}
