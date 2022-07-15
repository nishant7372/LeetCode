class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> a = new ArrayList<>();
        
        int totalSum=0;
        for(int x:nums)
        {
            totalSum+=x;
        }
        
        int sum=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            sum+=nums[i];
            if(sum<=totalSum-sum)
            {
                a.add(nums[i]);
            }
            else
            {
                a.add(nums[i]);
                break;
            }
        }
        return a;
    }
}
