class Trie {
    Trie[] a;
    boolean stop;
    public Trie() {
        this.stop=false;
        this.a=new Trie[26];
    }
    
    public void insert(String word) {
        Trie main=this; 
        for(int i=0;i<word.length();i++){
            if(main.a[word.charAt(i)-'a']==null)
            main.a[word.charAt(i)-'a']=new Trie();
            main=main.a[word.charAt(i)-'a'];
        }
        main.stop=true;
    }
    
    public boolean search(String word) {
        Trie main=this;
        for(int i=0;i<word.length();i++){
            if(main.a[word.charAt(i)-'a']==null)
            return false;
            main=main.a[word.charAt(i)-'a'];
        }
        return main.stop;
    }
    
    public boolean startsWith(String prefix) {
        Trie main=this;
        for(int i=0;i<prefix.length();i++){
            if(main.a[prefix.charAt(i)-'a']==null)
            return false;
            main=main.a[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
