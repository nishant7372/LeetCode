// Kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int max_Sum=Integer.MIN_VALUE;
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
            if(sum>max_Sum)
                max_Sum=sum;
            if(sum<0)
                sum=0;
        }
        return max_Sum;
    }
}

// Divide and Conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums,0,nums.length-1);
    }

    private int solve(int[] nums,int l,int r){
        if(l==r){
            return nums[l];
        }
        int m = (l+r)/2;
        int left = solve(nums,l,m);
        int right = solve(nums,m+1,r);
      
        int sum=0, a=m, b=m+1;

        int lSum=nums[a], rSum=nums[b];
        while(a>=l){
            sum+=nums[a--];
            lSum = Math.max(sum,lSum);
        }
        sum=0;
        while(b<=r){
            sum+=nums[b++];
            rSum = Math.max(sum,rSum);
        }
        return Math.max(lSum+rSum,Math.max(left,right));
    }
}
