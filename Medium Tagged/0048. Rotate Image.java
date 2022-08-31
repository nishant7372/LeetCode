class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
        
       //Transpose the Matrix
       for(int i=0;i<n;i++)
       {
           for(int j=i;j<n;j++)
           {
              int temp =  matrix[i][j];
              matrix[i][j] = matrix[j][i]; 
              matrix[j][i]=temp;
           }
       }
        
       //Reverse rows of matrix 
       for(int[] row:matrix)
       {
           int i=0;
           int j=n-1;
           while(i<j)
           {
              int temp =  row[i];
              row[i++] = row[j]; 
              row[j--] = temp;
           }
       }
    }
}
