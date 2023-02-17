// Method 1
// 5ms runtime Beats 90%
// Binary Search + Sorting
// Time -> O(nlogn)
// Space -> O(1)

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Integer prev = null;
        int count=0;
        int i=0;
        for(int x:nums){
            int idx = Arrays.binarySearch(nums,i+1,nums.length,x+k);
            if(idx>0 && (prev==null || x!=prev)){
                count++;
            }
            prev=x;
            i++;
        }
        return count;
    }
}

// Method 2 
// 8ms runtime Beats 68%
// Two Pointers + Sorting
// Time -> O(nlogn)
// Space -> O(1)

class Solution {
    public int findPairs(int[] arr, int k) {
    Arrays.sort(arr);
    
    int c=0;
    int i=0;
    int j=1;
    int prev1=Integer.MIN_VALUE;
    int prev2=Integer.MIN_VALUE;
    while(i<arr.length&&j<arr.length)
    {
        if(i==j)
            j++;
        if(j<arr.length&&arr[j]-arr[i]==k)
        {
            if(arr[i]!=prev1||arr[j]!=prev2)
            {
                prev1=arr[i];
                prev2=arr[j];
                c++;
            }
            j++;
            i++;
        }
        if(j<arr.length&&arr[j]-arr[i]<k)
            j++;
        else if(j<arr.length&&arr[j]-arr[i]>k)
            i++;
    }
    
    return c;

    }
}
