class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        return -1;
        ArrayList<Integer>[] a = new ArrayList[n];
        for(int i=0;i<n;i++)
        a[i]=new ArrayList<Integer>();

        for(int[] x:connections)
        {
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }
        boolean visited[] = new boolean[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                dfs(i,a,visited);
                c++;
            }
        }
        return c-1;
    }

    private void dfs(int x,ArrayList<Integer>[] a,boolean[] visited)
    {
        visited[x]=true;
        for(int y:a[x]){
            if(!visited[y])
            dfs(y,a,visited);
        }
    }
}
