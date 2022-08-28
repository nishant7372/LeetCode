class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>[] a= new ArrayList[n];
        
        for(int i=0;i<n;i++)
            a[i] = new ArrayList<Integer>();
        
        for(int[] x:edges){
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        for(int x:a[source])
            st.push(x);
        visited[source]=true;
        while(!st.isEmpty()){
            int currNode = st.pop();
            if(currNode==destination)
                return true;
            if(!visited[currNode]){
                for(int x:a[currNode])
                    st.push(x);
                visited[currNode]=true;
            }
        }
        return false;
    }
}
