class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        int[] res = new int[nums.length-k+1];

        for(int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        int j=0;
        for(int i=k;i<nums.length;i++)
        {
            res[j++]=queue.peek()[0];
            queue.add(new int[]{nums[i],i});
            
            while(!queue.isEmpty() && queue.peek()[1]<=i-k)
                queue.remove();
        }
        res[j++]=queue.peek()[0];
        return res;
    }
}
