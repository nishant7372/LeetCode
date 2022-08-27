class Solution {
    public int[][] generateMatrix(int n) {
        if(n==1)
            return new int[][]{{1}};
        int[][] a = new int[n][n];
        
        int m=1;   //m is the number to be filled
        int i=0;   //row index
        int j=0;   //column index
        while(a[i][j]==0){
            
        //left -> right
            while(j<n&&a[i][j]==0)  //Always checking the next box to be filled for zero or not
                a[i][j++]=m++;
           j--;
           i++;
        //top -> bottom
            while(i<n&&a[i][j]==0)
                a[i++][j]=m++;
           i--;
           j--;
        //right -> left
            while(j>-1&&a[i][j]==0)
                a[i][j--]=m++;
           i--;
           j++;
        
        // bottom -> top
            while(i>-1&&a[i][j]==0)
                a[i--][j]=m++;
            i++;
            j++;
        }
            
        return a;
    }
}
