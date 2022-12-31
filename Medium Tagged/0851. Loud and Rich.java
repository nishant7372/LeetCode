//Optimized --> 1ms runtime Faster than 99%
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
