// Method 1 --> Counting Sort --> O(n+k) solution
// Time --> O(n+k)
// Space --> O(n+k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int x:nums){
            if(x>max)
               max=x;
            if(x<min)
               min=x;
        }

        int[] a = new int[max-min+1];

        for(int x:nums){
            a[x-min]++;
        }

        for(int i=a.length-1;i>=0;i--){
            while(a[i]-->0){
                k--;
                if(k==0)
                   return i+min;
            }
        }
        return 0;
    }
}

// Method 2 --> Sorting --> O(nlogn) solution
// Time --> O(nlogn)
// Space --> O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

// Method 3 --> QuickSelect Solution 

// to be updated soon
