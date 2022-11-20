class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
            if(st.isEmpty())
                st.push(new int[]{temperatures[i],i});
            else
            {
                while(!st.isEmpty() && st.peek()[0]<temperatures[i])
                {
                    int[] a = st.pop();
                    res[a[1]] = i-a[1]; 
                }
                st.push(new int[]{temperatures[i],i});
            }
        }
        return res;
    }
}
