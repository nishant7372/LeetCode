//Method 1 --> Boyer's Moore Majority Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int count=0;  //votes
        int element=-1; //candidate
        
        for(int x:nums)
        {
            if(count==0){
                count++;
                element=x;
            }
            else if(x==element)
                count++;
            else
                count--;
        }
        return element;
    }
}
//Method 2 --> Sorting

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int c=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                c++;
            if(c>nums.length/2)
                return nums[i];
            if(nums[i]!=nums[i+1])
                c=1;
        }
        return nums[nums.length-1];
    }
}
