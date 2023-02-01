// Method 1 --> O(1) space 

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        m  = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = fill(i,j,board)==board[i][j]? board[i][j]+5:board[i][j];
            }
        }

        // Restoring 
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]>=5)
                   board[i][j]-=5;
                else 
                   board[i][j]= board[i][j]==0?1:0;
            }
        }
    }


    private int fill(int i,int j,int[][] board)
    {
        int one=0;
        int zero=0;
        for(int x=i-1;x<=i+1;x++)
        {
            for(int y=j-1;y<=j+1;y++)
            {
                if(x==i && y==j)
                   continue;
                if(x>=0 && x<m && y>=0 && y<n){
                    if(board[x][y]==1||board[x][y]==6)
                       one++;
                    else
                       zero++;
                }
            }
        }  

        if(board[i][j]==0){
            if(one==3)
               return 1;
            else
               return 0;
        }
        else{
            if(one<2 || one>3)
               return 0;
            else
               return 1;
        }
    } 
}

// Method 2 --> O(m*n) space 

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        m  = board.length;
        n = board[0].length;
        int[][] mat = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j] = fill(i,j,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = mat[i][j];
            }
        }
    }


    private int fill(int i,int j,int[][] board)
    {
        int one=0;
        int zero=0;
        for(int x=i-1;x<=i+1;x++)
        {
            for(int y=j-1;y<=j+1;y++)
            {
                if(x==i && y==j)
                continue;
                if(x>=0 && x<m && y>=0 && y<n){
                    if(board[x][y]==1)
                       one++;
                    else
                       zero++;
                }
            }
        }

        if(board[i][j]==0){
            if(one==3)
            return 1;
            else
            return 0;
        }
        else{
            if(one<2 || one>3)
            return 0;
            else
            return 1;
        }
    } 
}
