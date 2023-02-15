// Binary Search 
// 0ms runtime Beats 100%

class Solution {
    public int search(int[] nums, int target) {
        int start=0;
	int end=nums.length;
	while(start<end)
	{
	   int mid=(start+end)/2;
	   if(nums[mid]==target)
		return mid;
	   else if(nums[mid]>target)
		end = mid;
	   else
	        start=mid+1;
	}
	return -1;
    }
}

// Ternary Search 
// 0ms runtime Beats 100%

class Solution {
    public int search(int[] arr, int target) {
        int i=0, j=arr.length-1;

        while(i<=j){
            int mid1 = i+(j-i)/3;
            int mid2 = j-(j-i)/3;
        
            if(arr[mid1]==target){
                return mid1;
            }
            if(arr[mid2]==target){
                return mid2;
            }
            if(arr[mid1]>target){
                j=mid1-1;
            }
            else if(arr[mid2]<target){
                i=mid2+1;
            }
            else{
                i=mid1+1;
                j=mid2-1;
            }
        }
        return -1;
    }
}
