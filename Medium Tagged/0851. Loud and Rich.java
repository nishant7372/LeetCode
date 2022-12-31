//Method 1 --> Optimized
//5ms runtime Faster than 99.7%
//Time Complexity - O(n) ; n=quiet.length;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<Integer>[] a = new ArrayList[quiet.length];

        for(int i=0;i<a.length;i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int[] x:richer){
            a[x[1]].add(x[0]);
        }

        int[] res = new int[a.length];
        Arrays.fill(res,-1);

        for(int i=0;i<quiet.length;i++){
            if(res[i]==-1)
               dfs(a,i,quiet,res);
        }
        return res;
    }

    private int dfs(ArrayList<Integer>[] a,int x,int[] quiet,int[] res)
    {
        if(res[x]!=-1)
           return res[x];
        int min=x;
        for(int y:a[x])
        {
            int r = dfs(a,y,quiet,res);
            if(quiet[r]<quiet[min])
               min=r;
        }
        return res[x]=min;
    }
}


//Method 2
//104ms runtime Faster than 12.96%
//Time Complexity - O(n*n) ; n=quiet.length;

class Solution {
    int min;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<Integer>[] a = new ArrayList[quiet.length];

        for(int i=0;i<quiet.length;i++)
        a[i] = new ArrayList<Integer>();

        for(int[] x:richer)
        {
            a[x[1]].add(x[0]);
        }

        int[] res = new int[a.length];
        for(int i=0;i<quiet.length;i++)
        {
            boolean[] visited = new boolean[a.length];
            min=i;
            dfs(a,i,quiet,visited);
            res[i]=min;
        }
        return res;
    }

    private void dfs(ArrayList<Integer>[] a,int x,int[] quiet,boolean[] visited)
    {
        if(visited[x])
           return;
        if(quiet[x]<quiet[min]){
           min=x;
        }
        visited[x]=true;
        for(int y:a[x])
        {
            dfs(a,y,quiet,visited);
        }
    }
}
