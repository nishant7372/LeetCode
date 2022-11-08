class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
		 if(word.length()>m*n)
            return false;
			
		// ------------- Comparing Frequency of Characters to avoid searching -----------------------
		
        int[] a = new int[52];
        int[] b = new int[52];
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)<='Z')
                a[word.charAt(i)-'A']++;
            else
                a[word.charAt(i)-'a'+26]++;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]<='Z')
                    b[board[i][j]-'A']++;
                else
                    b[board[i][j]-'a'+26]++;
            }
        }
        for(int i=0;i<52;i++)
            if(a[i]>b[i])
                return false;
				
       // ----------------------------------------------------------------------------------------------
	   
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    
    private boolean backtrack(char[][] board,String word,int i,int j,int len)
    {
        if(i==-1||j==-1||i==m||j==n)
            return false;
        
        if(word.charAt(len++)!=board[i][j])
            return false;
        
        if(word.length()==len)
             return true;
        
        board[i][j]='*';  //marking as visited
        
       boolean res= false;
        if(backtrack(board,word,i+1,j,len))
            res = true;
        else if(backtrack(board,word,i-1,j,len))
            res = true;
        else if(backtrack(board,word,i,j+1,len))
            res = true;
        else if(backtrack(board,word,i,j-1,len))
            res = true;
        board[i][j]=word.charAt(len-1);  // retrieving the original character
        return res;
    }
}
