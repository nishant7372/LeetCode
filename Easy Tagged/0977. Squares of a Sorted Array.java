Method 1 --> Using Two-pointers
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int index=j;
        while(i<=j){
            int start = nums[i]*nums[i];
            int end = nums[j]*nums[j];
            if(start>end){
                res[index--]=start;
                i++;
            }
            else{
                res[index--]=end;
                j--;
            }
        }
        return res;
    }
}
Method 2 --> Using Counting-Sort
class Solution {
    public int[] sortedSquares(int[] nums) {
        int max=0;
        for(int x:nums){
            if(Math.abs(x)>max)
                max=Math.abs(x);
        }
        int[] a = new int[max+1];
        for(int x: nums){
            a[Math.abs(x)]++;
        }
        int j=0;
        for(int i=0;i<a.length;i++){
            while(a[i]-->0)
            nums[j++]=i*i;
        }
        return nums;
    }
}
Method 3 --> Using Inbuilt Sort Function
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
