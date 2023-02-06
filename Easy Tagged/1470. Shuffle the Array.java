// Iterative Solution --> O(n) time and O(n) space

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[2*n];
        for(int i=0;i<n;i++){
            a[2*i]=nums[i];
            a[2*i+1]=nums[i+n];
        }
        return a;
    }
}

// Recursive Solution --> O(n) time and O(n) space

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[2*n];
        fill(nums,a,0,n);
        return a;
    }

    private void fill(int[] nums,int[] a,int i,int n){
        if(i==n)
           return;
        a[2*i]=nums[i];
        a[2*i+1]=nums[i+n];
        fill(nums,a,i+1,n);
    }
}
