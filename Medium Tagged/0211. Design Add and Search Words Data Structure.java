// Beats 96.65% Using Trie

class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        Trie t = trie;
        for(char ch:word.toCharArray()){
            if(t.a[ch-'a']==null)
               t.a[ch-'a'] = new Trie();
            t = t.a[ch-'a'];
        }
        t.stop=true;
    }
    
    public boolean search(String word) {
        return search(word.toCharArray(),trie,0);
    }

    private boolean search(char[] s,Trie t,int i){
        if(i==s.length)
            return t.stop;
        if(s[i]!='.')
            return t.a[s[i]-'a']==null? false: search(s,t.a[s[i]-'a'],i+1);
        else{
            for(Trie x:t.a)
                if(x!=null && search(s,x,i+1))
                    return true;
            return false;
        }
    }
}

class Trie{
    Trie[] a;
    boolean stop;
    public Trie(){
        a = new Trie[26];
        this.stop=false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
