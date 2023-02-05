// Method 1 --> Without Stack (Beats 60%) --> O(n) time O(1) space

class Solution {
    public int minDeletion(int[] nums) {
        int del=0, top=-1, last=0;
        for(int x:nums)
        {
            if(top%2==0&&last==x)  // nums[i]!=nums[i+1] ∀ i%2==0.
                  del++;
            else
            {
                last=x;
                top++; // top acts as a index for undeleted elements
            }
        }
        return top%2==0? del+1:del; //nums.length will be even when top is odd
    }
}

// Method 2 --> Using Stack (Beats 20%) --> O(n) time O(n) space

class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int del=0, top=-1;
        for(int x:nums)
        {
            if(top%2==0&&st.peek()==x)  // nums[i]!=nums[i+1] ∀ i%2==0.
                  del++;
            else
            {
                st.push(x);
                top++; // top acts as a index for undeleted elements
            }
        }
        return top%2==0? del+1:del; //nums.length will be even when top is odd
    }
}
