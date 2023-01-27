// Approach 1 (350ms runtime Beats 15.42%) --> Using Stack (To be Optimized with Binary Search)

class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<int[]> st = new Stack<>();
        int[] prevSmaller = new int[nums.length];
        int[] nextSmaller = new int[nums.length];
       
        //finding index of next smaller element for each nums[i]
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0]>nums[i]){
                prevSmaller[st.pop()[1]]=i;
            }
            st.push(new int[]{nums[i],i});
        }
        while(!st.isEmpty()){
            prevSmaller[st.pop()[1]]=-1;
        }

         //finding index of prev smaller element for each nums[i]
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && st.peek()[0]>nums[i]){
                nextSmaller[st.pop()[1]]=i;
            }
            st.push(new int[]{nums[i],i});
        }
        while(!st.isEmpty()){
            nextSmaller[st.pop()[1]]=nums.length;
        }

        //finding maxScore from score of each subarray with minimum, nums[i]
        
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(prevSmaller[i]<k && k<nextSmaller[i]){
               max=Math.max(max,nums[i]*(nextSmaller[i]-prevSmaller[i]-1));
            }
        }

        return max;
    }
}
