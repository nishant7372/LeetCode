class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i]-i)==null)
                map.put(nums[i]-i,1);
            else
                map.put(nums[i]-i,map.get(nums[i]-i)+1);
        }
        long sum=0;
        for(int x:map.values())
            sum+=((long)x*(x-1))/2; //Counting pairs that are not bad
        long total = ((long)(nums.length)*(nums.length-1))/2;
        return total-sum;
    }
}
