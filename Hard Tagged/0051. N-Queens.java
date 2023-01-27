//Code 1 --> 3ms runtime Faster than 84%

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(); //result list
        char[][] a = new char[n][n]; //temporary 2D states array
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],'.'); //fill array with '.'
        solve(0,res,a); //start with 0th queen.
        return res;
    }
    
    // queens are numbered from 0 to n-1
    // i-->queen/row
    private void solve(int i,List<List<String>> res,char[][] a){
        //if i==n (all queens placed)
        if(i==a.length)
            res.add(makeArrayList(a)); //adding list to result
        
        for(int col=0;col<a.length&&i<a.length;col++){
            if(place(i,col,a)){
                a[i][col]='Q'; //mark the filled position
                solve(i+1,res,a);  //place next Queen.
                a[i][col]='.';  //unmark the filled position
            }
        }
    }
    

    //making ArrayList from array
    private ArrayList<String> makeArrayList(char[][] a){
        ArrayList<String> list = new ArrayList<>();
        for(char[] x:a)
            list.add(String.valueOf(x));
        return list;
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


//Code 2 --> Handling more Variables (3ms runtime Faster than 84%)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] a = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],'.'); //fill array with '.'
        solve(0,-1,res,a); //start with 0,-1 to avoid filling for one cell only.
        return res;
    }
    
    // queens are numbered from 0 to n-1
    // i-->queen/row, j--> col 
    private void solve(int i,int j,List<List<String>> res,char[][] a){
        if(!place(i,j,a))
            return;
        if(j!=-1)
            a[i++][j]='Q'; //mark the queen  
        //if i==n (all queens palced)
        if(i==a.length){ 
            res.add(makeArrayList(a)); //adding list to result
            a[--i][j]='.'; //unmark the queen  
            return;
        }
        for(int col=0;col<a.length;col++)
            solve(i,col,res,a);  //check for all columns.
        
        if(j!=-1)
           a[--i][j]='.'; //unmark the queen  
    }
    

    //making ArrayList from array
    private ArrayList<String> makeArrayList(char[][] a){
        ArrayList<String> list = new ArrayList<>();
        for(char[] x:a)
            list.add(String.valueOf(x));
        return list;
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
