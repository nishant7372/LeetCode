class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(j==0 ||  board[i][j-1]=='#'){
                    // System.out.println(i+"-->"+j);
                if(placeForward(i,j,word,board))
                return true;
                }
                if(j==board[0].length-1 ||  board[i][j+1]=='#'){
                    // System.out.println(i+"-->"+j);
                if(placeBackward(i,j,word,board))
                return true;
                }
            }
        }
        for(int i=0;i<board[0].length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(j==0 ||  board[j-1][i]=='#'){
                    // System.out.println(j+"-->"+i);
                if(placeForward1(i,j,word,board))
                return true;
                }
                if(j==board.length-1 ||  board[j+1][i]=='#'){
                    // System.out.println(j+"-->"+i);
                if(placeBackward1(i,j,word,board))
                return true;
                }
            }
        }
        return false;
    }

    private boolean placeForward(int i,int j,String word,char[][] board)
    {
        if(board[0].length-j<word.length())
        return false;
        int idx=0;
        int k;
        for(k=j;k<j+word.length();k++)
        {
            if(board[i][k]==' '||board[i][k]==word.charAt(idx))
            idx++;
            else 
            return false;
            // System.out.println(i+","+k);
        }
        // System.out.println();
        if(k==board[0].length || board[i][k]=='#')
        return true;
        return false;
    }

    private boolean placeBackward(int i,int j,String word,char[][] board)
    {
        if(j+1<word.length())
        return false;
        int idx=0;
        int k;
        for(k=j;k>j-word.length();k--)
        {
           if(board[i][k]==' '||board[i][k]==word.charAt(idx))
            idx++;
            else 
            return false;
            // System.out.println(i+","+k);
        }
        // System.out.println();
        if(k==-1|| board[i][k]=='#')
        return true;
        return false;
    }

    private boolean placeForward1(int i,int j,String word,char[][] board)
    {
        if(board.length-j<word.length())
        return false;
        int idx=0;
        int k;
        for(k=j;k<j+word.length();k++)
        {
            if(board[k][i]==' '||board[k][i]==word.charAt(idx))
            idx++;
            else 
            return false; 
            // System.out.println(k+","+i);
        }
        // System.out.println();
        if(k==board.length || board[k][i]=='#')
        return true;
        return false;
    }

    private boolean placeBackward1(int i,int j,String word,char[][] board)
    {
        if(j+1<word.length())
        return false;
        int idx=0;
        int k;
        for(k=j;k>j-word.length();k--)
        {
            if(board[k][i]==' '||board[k][i]==word.charAt(idx))
            idx++;
            else 
            return false;
            // System.out.println(k+","+i);
        }
        // System.out.println();
        if(k==-1 || board[k][i]=='#')
        return true;
        return false;
    }
}
