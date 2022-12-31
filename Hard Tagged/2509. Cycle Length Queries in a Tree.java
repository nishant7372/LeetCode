class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int i=0;
        for(int[] x:queries)
        {
            int a = x[0];
            int b = x[1];
            int c=0;
            while(a!=b)
            {
                if(a>b)
                a/=2;
                else
                b/=2;
                c++;
            }
            res[i++]=c+1;
        }
        return res;
    }
}
