class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int i=0;
        int j=nums.length-1;
        while(i<j)
        {
            set.add(nums[i]+nums[j]);
            i++;
            j--;
        }
        return set.size();
    }
}
