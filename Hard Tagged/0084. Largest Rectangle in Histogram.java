// Beats 37% 240ms runtime --> Using Stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>(); //storing indexes only.
        int[] prevSmaller = new int[heights.length];
        int[] nextSmaller = new int[heights.length];
       
        //finding index of next smaller element for each heights[i]
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                prevSmaller[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            prevSmaller[st.pop()]=-1;
        }

         //finding index of prev smaller element for each heights[i]
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                nextSmaller[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nextSmaller[st.pop()]=heights.length;
        }

        //finding maxArea from area of each rectangle of height, heights[i]
        //width of a rectange can be computed by (nextSmaller[i]-prevSmaller[i]-1)
        int max=0;
        for(int i=0;i<heights.length;i++)
            max=Math.max(max,heights[i]*(nextSmaller[i]-prevSmaller[i]-1));

        return max;
    }
}
