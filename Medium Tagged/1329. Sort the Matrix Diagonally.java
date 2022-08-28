//Method 1
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat.length;i++)
             sort(mat,i,0);      //sorting the diagonals starting with col 0
        for(int j=1;j<mat[0].length;j++)
             sort(mat,0,j);     //sorting the diagonals starting with row 0
        return mat;
    }
    
    
    private void sort(int[][] matrix, int row,int col)
    {
        int size = Math.min(matrix.length-row,matrix[0].length-col);
        int[] a = new int[100];

        for(int i=0;i<size;i++)
            a[100-matrix[row++][col++]]++;         //counting sort  --> reverseSorting(Descending Order)
        
        int i=0;
        while(size>0){
            while(a[i]-->0){
                matrix[--row][--col]=100-i;      //fill the diagonal with the sorted elements
                size--;
            }
            i++;
        }
    }
}

//Method 2
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat.length;i++)
             sort(mat,i,0);       //sorting the diagonals starting with col 0
        for(int j=1;j<mat[0].length;j++)
             sort(mat,0,j);       //sorting the diagonals starting with row 0
        return mat;
    }
    
    
    private void sort(int[][] matrix, int row,int col)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();   

        while(row<matrix.length&&col<matrix[0].length)
            a.add(matrix[row++][col++]);              //adding the diagonal elements to an ArrayList

        Collections.sort(a,Collections.reverseOrder());    //Sorting the ArrayList in reverseOrder
        
        for(int x:a)
            matrix[--row][--col]=x;                   //fill the diagonal with the sorted elements
    }
}
