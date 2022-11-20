class Solution {
    public boolean validTicTacToe(String[] board) {
        int x=0;
        int y=0;
        int c1=0;
        int c2=0;
        
        StringBuffer sb = new StringBuffer();
        //----same rows
        for(int i=0;i<board.length;i++){
        if(board[i].equals("OOO"))
            c1++;
        if(board[i].equals("XXX"))
            c2++;
        }
     
        //----Same Diagonals
        sb.append(board[0].charAt(0)).append(board[1].charAt(1)).append(board[2].charAt(2));
        if(sb.toString().equals("OOO"))
                c1++;
        if(sb.toString().equals("XXX"))
                c2++;
       sb=new StringBuffer();
        sb.append(board[0].charAt(2)).append(board[1].charAt(1)).append(board[2].charAt(0));
        if(sb.toString().equals("OOO"))
                c1++;
        if(sb.toString().equals("XXX"))
                c2++;
        
        //----Same Columns
        for(int j=0;j<board.length;j++){
            sb=new StringBuffer();
            for(int i=0;i<board.length;i++)
                sb.append(board[i].charAt(j));
            if(sb.toString().equals("XXX"))
                c2++;
            if(sb.toString().equals("OOO"))
                c1++;
        }
        
        
        if(c1>0 && c2>0)
            return false;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i].charAt(j)=='X')
                    x++;
                else if(board[i].charAt(j)=='O')
                    y++;
            }
        }
        
        if(c2>0 && x==y)
            return false;
        if(c1>0 && x-y==1)
            return false;
        if(x==y||x-y==1)
            return true;
        return false;
    }
}
