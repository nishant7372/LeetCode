class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int i = helper(matrix, target);
         return search(matrix, target, i);
    }
    private boolean search(int[][] matrix, int target, int i)
    {
       int start=0;
       int end = matrix[0].length-1;
       while(start<=end)
       {
           int mid=(start+end)/2;
           if(matrix[i][mid]==target)
               return true;
           if(matrix[i][mid]<target)
               start=mid+1;
           else 
               end=mid-1;
       }
        return false;
    }
    private int helper(int[][] matrix, int target)
    {
        for(int i=0;i<matrix.length-1;i++)
        {
            if(matrix[i][0]<=target&&matrix[i+1][0]>target)
                return i;   
        }
        return matrix.length-1;
    }
}
