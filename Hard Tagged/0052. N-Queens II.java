//Code 1 --> 2ms runtime Faster than 81%

class Solution {
    int res;
    public int totalNQueens(int n) {
        char[][] a = new char[n][n]; //temporary 2D states array
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],'.'); //fill array with '.'
        solve(0,a); //start with 0th queen.
        return res;
    }
    
    // queens are numbered from 0 to n-1
    // i-->queen/row
    private void solve(int i,char[][] a){
        //if i==n (all queens placed)
        if(i==a.length)
            res++; //incrementing solution count
        
        for(int col=0;col<a.length&&i<a.length;col++){
            if(place(i,col,a)){
                a[i][col]='Q'; //mark the filled position
                solve(i+1,a);  //place next Queen.
                a[i][col]='.';  //unmark the filled position
            }
        }
    }

    //checking if ith queen can be placed in ith row and jth col.
    private boolean place(int row,int col,char[][] a){
        for(int i=0;i<row;i++){
            if(a[i][col]=='Q') //if same col
              return false;
            if(col-row+i>=0 && a[i][col-row+i]=='Q') //if same left diagonal
              return false;
            if(col+row-i<a.length && a[i][col+row-i]=='Q') //if same right diagonal
              return false;
        }
        return true;
    }
}


//Code 2 --> Handling More Variables. (2ms runtime Faster than 81%)

class Solution {
    int res;
    public int totalNQueens(int n) {
        char[][] a = new char[n][n]; //temporary states 2D array
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],'.'); //fill array with '.'
        solve(0,-1,a); //start with 0,-1 to avoid filling for one cell only.
        return res;
    }
    
    // queens are numbered from 0 to n-1
    // i-->queen/row, j--> col 
    private void solve(int i,int j,char[][] a){
        if(!place(i,j,a))
            return;
        if(j!=-1)
            a[i++][j]='Q'; //mark the queen  
        //if i==n (all queens palced)
        if(i==a.length)
            res++;
            
        for(int col=0;col<a.length&&i<a.length;col++)
            solve(i,col,a);  //check for all columns.
        
        if(j!=-1)
           a[--i][j]='.'; //unmark the queen  
    }

    //checking if ith queen can be placed in ith row and jth col.
    private boolean place(int row,int col,char[][] a){
        for(int i=0;i<row;i++){
            if(a[i][col]=='Q') //if same col
              return false;
            if(col-row+i>=0 && a[i][col-row+i]=='Q') //if same left diagonal
              return false;
            if(col+row-i<a.length && a[i][col+row-i]=='Q') //if same right diagonal
              return false;
        }
        return true;
    }
}
