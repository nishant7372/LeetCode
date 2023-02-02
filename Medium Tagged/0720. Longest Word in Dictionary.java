// 11ms runtime, Beats 80% (Using Trie)

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String s:words)
           add(trie,s);

        String max="";
        for(String s:words){
            if(check(trie,s)){
                if((s.length()==max.length() && s.compareTo(max)<0) || s.length()>max.length()) 
                   max=s;
            }
        }
        return max;
    }

    private void add(Trie trie,String s){
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null)
                trie.a[ch-'a']=new Trie();
            trie = trie.a[ch-'a'];
        }
        trie.stop=true;
    }

    private boolean check(Trie trie,String s){
        for(char ch:s.toCharArray()){
            trie = trie.a[ch-'a'];
            if(!trie.stop)
               return false;
        }
        return true;
    }
}

class Trie{
    Trie a[];
    boolean stop;
    public Trie(){
        this.a = new Trie[26];
        this.stop = false;
    }
}
