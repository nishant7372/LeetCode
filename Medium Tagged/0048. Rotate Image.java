class Solution {
    public void rotate(int[][] matrix) {
       int l1 = matrix.length;
       for(int i=0;i<l1;i++)
       {
           for(int j=i;j<l1;j++)
           {
              int temp =  matrix[i][j];
              matrix[i][j] = matrix[j][i]; 
              matrix[j][i]=temp;
           }
       }
       for(int i=0;i<l1;i++)
       {
           int j=0;
           int k=l1-1;
           while(j<k)
           {
              int temp =  matrix[i][j];
              matrix[i][j] = matrix[i][k]; 
              matrix[i][k]=temp;
              j++;
              k--;
           }
       }
    }
}
