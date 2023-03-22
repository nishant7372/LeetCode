class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=0,c=0;
        while(j<nums.length){
            if(nums[i]<nums[j]){
                i++;
                c++;
            }
            j++;
        }
        return c;
    }
}
