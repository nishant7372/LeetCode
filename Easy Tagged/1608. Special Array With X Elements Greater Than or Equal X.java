// Method 1 - Binary Search + Linear Search (to find count of elements>=mid), 0ms runtime Beats 100%

class Solution {
    public int specialArray(int[] nums) {
        int i=0,j=nums.length;
        while(i<=j){
            int mid = i+(j-i)/2;
            int count = 0; // elements>=mid
            for(int x:nums){
                if(x>=mid)
                   count++;
            }
            if(mid == count)
               return mid;
            else if(mid > count)
                j=mid-1;
            else
                i=mid+1;
        }
        return -1;
    }
}


// Method 2 - a. Counting Sort O(n+k) + Binary Search (log(logn)), 1ms runtime Beats 78%

class Solution {
    public int specialArray(int[] nums) {
        int max=0;
        for(int x:nums)
            max=Math.max(max,x);

        int[] a = new int[max+1];
        for(int x:nums)
            a[x]++;

        int k=0;
        for(int i=0;i<=max;i++){
            while(a[i]-->0)
                nums[k++]=i;
        }
        int i=0,j=nums.length;
        while(i<=j){
            int mid = i+(j-i)/2;
            int count = nums.length-indexOf(mid,nums); // elements>=mid
            if(mid == count)
               return mid;
            else if(mid > count)
                j=mid-1;
            else
                i=mid+1;
        }
        return -1;
    }

    private int indexOf(int target,int[] nums){
        int i=0, j=nums.length;

        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]<target)
               i=mid+1;
            else
               j=mid;
        }
        return i;
    }
}

// Method 2 - b. Arrays.sort(nlogn) + Binary Search (log(logn)), 1ms runtime Beats 78%

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        while(i<=j){
            int mid = i+(j-i)/2;
            int count = nums.length-indexOf(mid,nums); // elements>=mid
            if(mid == count)
               return mid;
            else if(mid > count)
                j=mid-1;
            else
                i=mid+1;
        }
        return -1;
    }

    private int indexOf(int target,int[] nums){
        int i=0, j=nums.length;

        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]<target)
               i=mid+1;
            else
               j=mid;
        }
        return i;
    }
}
