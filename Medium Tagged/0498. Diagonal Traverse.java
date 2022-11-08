class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m= mat.length;
        int n = mat[0].length;
        ArrayList<Integer>[] a = new ArrayList[m+n+1];
       
        for(int i=0;i<a.length;i++){
            a[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i+j].add(mat[i][j]);
            }
        }
        
        int[] res = new int[m*n];
        int k=0;
        for(int i=0;i<a.length;i++)
        {
            if(i%2==0)
                Collections.reverse(a[i]);
            for(int x:a[i])
            {
                res[k++]=x;
            }
        }
        return res;
    }
}
