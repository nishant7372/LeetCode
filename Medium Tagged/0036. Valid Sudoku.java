class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
           if(check_row(i,board))
               return false;
           if(check_col(i,board))
               return false;
        }
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {
                if(check_block(i,j,board))
                return false;
            }
        }
        return true;
    }
    
    static boolean check_row(int row,char[][] board)
    {
        int[] a = new int[9];
        for(int col=0;col<9;col++)
        {
            if(board[row][col]!='.')
            a[board[row][col]-'1']++;
        }
        for(int x:a)
        {
            if(x>1)
                return true;
        }
        return false;
    }
    
    static boolean check_col(int col,char[][] board)
    {
        int[] a = new int[9];
        for(int row=0;row<9;row++)
        {
            if(board[row][col]!='.')
            a[board[row][col]-'1']++;
        }
        for(int x:a)
        {
            if(x>1)
                return true;
        }
        return false;
    }
    
    static boolean check_block(int i,int j,char[][] board)
    {
        int[] a = new int[9];
        for(int row=i;row<i+3;row++)
        {
            for(int col=j;col<j+3;col++)
            { 
                if(board[row][col]!='.')
                a[board[row][col]-'1']++;
            }
        }
        for(int x:a)
        {
            if(x>1)
            return true;
        }
        return false;
    }
}
