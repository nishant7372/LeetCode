// 131ms runtime and 46% 
// Using LowerBound and UpperBound 

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res=0;
        for(int i=0;i<nums.length;i++){
            int a = lowerBound(nums,i+1,lower-nums[i]);
            int b = upperBound(nums,i+1,upper-nums[i]);
            res+=b-a;
        }
        return res;
    }

    // returns first index of target, if found
    // returns insertion index of target, if not found
    public int lowerBound(int[] arr,int i,int target){
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;  // mid = i+(j-i)/2
            if(arr[mid]>=target)
                j=mid-1;
            else
                i=mid+1;
        }
        return i;
    }

    // returns last index+1 of target, if found
    // returns insertion index of target, if not found
    public int upperBound(int[] arr,int i,int target){
        int j=arr.length-1;

        while(i<=j){
            int mid = (i+j)/2;  // mid = i+(j-i)/2
            if(arr[mid]<=target)
                i=mid+1;
            else
                j=mid-1;
        }
        return i;
    }
}

