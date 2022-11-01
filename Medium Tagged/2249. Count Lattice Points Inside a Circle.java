class Solution {
    public int countLatticePoints(int[][] circles) {
        int c=0;
        int[][] mat = new int[402][402];
        for(int[] circle:circles)
        {
            calc(circle,mat);
        }
        for(int[] x:mat)
        {
            for(int y:x)
            {
                if(y==1)
                    c++;
            }
        }
        return c;
    }
    
    private void calc(int[] circle,int[][] mat)
    {
        int x = circle[0];
        int y = circle[1];
        int r = circle[2];
      
        for(int i=x-r;i<=x+r;i++)
        {
            for(int j=y-r;j<=y+r;j++)
            {
                int a = x-i;
                int b = y-j;
                if(a*a+b*b<=r*r){
                    mat[i+201][j+201]=1;
                }
            }
        }
    }
}
