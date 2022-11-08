class Solution {
    int m,n;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        m=board.length;
        n=board[0].length;
        TrieNode root= createTrie(words);
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                backtrack(board,i,j,root,list);
            }
        }
        return list;
    }
    
    private void backtrack(char[][] board,int i,int j,TrieNode root,List<String> list)
    {
         if(i==-1||j==-1||i==m||j==n)
            return;
         char ch = board[i][j];
         if (ch == '*' || root.next[ch - 'a'] == null)
            return;
         root = root.next[ch - 'a'];
         if (root.word != null) {
             list.add(root.word);
             root.word = null;
         }        
        
        board[i][j]='*';  //marking as visited

        backtrack(board,i+1,j,root,list);
        backtrack(board,i-1,j,root,list);
        backtrack(board,i,j+1,root,list);
        backtrack(board,i,j-1,root,list);
        board[i][j]=ch;  //retrieving the original character
    }
    
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode createTrie(String[] words)
    {
        TrieNode root = new TrieNode();
        for(String s:words)
        {
            TrieNode curr = root;
            for(int i=0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                if(curr.next[ch-'a']==null)
                    curr.next[ch-'a']=new TrieNode();
                curr = curr.next[ch-'a'];
            }
            curr.word = s;
        }
        return root;
    }
}
