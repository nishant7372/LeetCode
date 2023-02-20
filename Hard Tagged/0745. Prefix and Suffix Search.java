// 220 ms runtime 
// Trie
// Beats 99.6%

class WordFilter {
    Trie pTrie, sTrie;
    public WordFilter(String[] words) {
        pTrie = new Trie();
        sTrie = new Trie();
        int i=0;
        for(String s:words)
            insert(s,i++);
    }

    public void insert(String s,int idx){
        Trie t1 = pTrie;
        Trie t2 = sTrie;
        for(int i=0, j=s.length()-1;i<s.length();i++, j--){
            if(t1.a[s.charAt(i)-'a']==null) 
                t1.a[s.charAt(i)-'a'] = new Trie();
            if(t2.a[s.charAt(j)-'a']==null) 
                t2.a[s.charAt(j)-'a'] = new Trie();

            t1=t1.a[s.charAt(i)-'a'];
            t2=t2.a[s.charAt(j)-'a'];
            t1.index.add(idx);
            t2.index.add(idx);
        }
    }
    
    public int f(String prefix, String suffix) {
        Trie t1 = pTrie;
        for(char ch:prefix.toCharArray()){
            if(t1.a[ch-'a']!=null)
                t1=t1.a[ch-'a'];
            else
                return -1;
        }

        Trie t2 = sTrie;
        for(int i=suffix.length()-1;i>=0;i--){
            if(t2.a[suffix.charAt(i)-'a']!=null)
                t2=t2.a[suffix.charAt(i)-'a'];
            else
                return -1;
        }

        ArrayList<Integer> a = t1.index, b = t2.index;
        if(a.size()==0 || b.size()==0)
           return -1;

        int i=a.size()-1, j=b.size()-1;
        while(i>=0 && j>=0){
            if(a.get(i).equals(b.get(j)))
               return a.get(i);
            if(a.get(i)>b.get(j))
                i--;
            else
                j--;
        }
        return -1;
    }
}

class Trie{
    Trie[] a;
    ArrayList<Integer> index;
    public Trie(){
        this.a = new Trie[26];
        this.index=new ArrayList<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
