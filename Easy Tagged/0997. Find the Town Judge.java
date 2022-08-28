class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedBy = new int[n+1];
        boolean[] trustsOn = new boolean[n+1];
        
        for(int[] x:trust){
            trustsOn[x[0]]=true;
            trustedBy[x[1]]++;
        }
        
        for(int i=1;i<=n;i++)
        {
            if(trustedBy[i]==n-1&&!trustsOn[i])
                return i;
        }
        return -1;
    }
}
