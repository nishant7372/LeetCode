// Beats 71.37% in time & 94.4% in space

class Solution {
    int m,n;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        m=board.length;
        n=board[0].length;
        Trie trie= new Trie();
        
        for(String s:words)
            add(trie,s);
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
               backtrack(board,i,j,trie,list);

        return list;
    }
    
    private void backtrack(char[][] board,int i,int j,Trie trie,List<String> list)
    {
        if(i==-1||j==-1||i==m||j==n)
           return;
        char ch = board[i][j];
        if(ch == '*' || trie.a[ch-'a']==null)
           return;
        trie = trie.a[ch - 'a'];
        if (trie.word != null){
           list.add(trie.word);
           trie.word = null; // deleting word from trie after addition to list to avoid duplicates
        }      
        board[i][j]='*';  // marking as visited
        backtrack(board,i+1,j,trie,list);  // up ↑
        backtrack(board,i-1,j,trie,list);  // down ↓
        backtrack(board,i,j+1,trie,list);  // right →
        backtrack(board,i,j-1,trie,list);  // left ←
        board[i][j]=ch;  // retrieving the original character
    }

    private void add(Trie trie,String s){
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null)
                trie.a[ch-'a']=new Trie();
            trie = trie.a[ch-'a'];
        }
        trie.word=s;
    }
}

 class Trie{
    Trie[] a;
    String word;
    public Trie(){
        this.a = new Trie[26];
        this.word=null;
    }
 }
