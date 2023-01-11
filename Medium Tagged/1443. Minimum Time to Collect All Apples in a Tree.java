class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] a = new ArrayList[n];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<Integer>();
        }
        for(int[] x:edges){
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }

        return dfs(-1,0,a,hasApple);
    }

    private int dfs(int prev,int i,ArrayList<Integer>[] a,List<Boolean> hasApple)
    {
        int ans=0;
        for(int x:a[i])
        {
            if(x!=prev){
               int res = dfs(i,x,a,hasApple);
               if(res>0||hasApple.get(x)){
                ans+=2+res;
               }
            }
        }
        return ans;
    }
}
