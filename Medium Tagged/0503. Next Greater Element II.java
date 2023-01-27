// O(2*n) Approach --> Using Stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);

        for(int i=0;i<n*2;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                res[st.pop()]=nums[i%n];
            }
            st.push(i%n);
        }
        return res;
    }
}

//O(n^2) --> Naive Method I

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] a = new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
            a[i]=search(nums,i,nums[i]);
        
        return a;
    }
    
    private int search(int[] nums, int j, int target)  //circular search
    {
        int i = (j==nums.length-1)?0:j+1;
        while(i!=j){
            if(nums[i]>target)
               return nums[i];
            i++; 
            if(i==nums.length)
               i=0;
        }
        return -1;
    }
}

//O(n^2) --> Naive Method II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] a = new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
            a[i]=search(nums,i+1,nums[i]);
        
        return a;
    }
    
    private int search(int[] nums, int j, int target) //circular search
    {
        for(int i=j;i<nums.length;i++)
        {
            if(nums[i]>target)
                return nums[i];
        }
        for(int i=0;i<j-1;i++)
        {
            if(nums[i]>target)
                return nums[i];
        }
        return -1;
    }
}
