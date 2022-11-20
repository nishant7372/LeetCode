class Solution {
    public int maxResult(int[] nums, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        queue.add(new int[]{dp[0],0});
        for(int i=1;i<nums.length;i++)
        {
            while(!queue.isEmpty() && queue.peek()[1]<i-k)
                queue.remove();
            dp[i]=nums[i]+queue.peek()[0];
            queue.add(new int[]{dp[i],i});
        }
        return dp[nums.length-1];
    }
}
