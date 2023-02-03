class Solution {
    static int mod = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int[] left = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int idx = st.pop();
                left[idx]=idx-i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            left[idx]=idx+1;
        }

        int[] right = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int idx=st.pop();
                right[idx]=i-idx;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx=st.pop();
            right[idx]=n-idx;
        }

        long sum=0;
        for(int i=0;i<n;i++){
            long c = (left[i]*right[i])%mod;
            c=(c*arr[i])%mod;
            sum=(sum+c)%mod;
        }
        return (int)sum;
    }
}
