// Beats 100% --> 0ms runtime (Without Trie)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=0, i=0;
        for(String x:strs)
        {
            if(x.length()<strs[min].length())
                min=i; 
            i++;
        }
        String s=strs[min];
        int c=0;
        for(int k=s.length();k>=1;k--){
            String p = s.substring(0,k); // prefix String
            for(String x:strs){
                if(x.startsWith(p))
                   c++;
            }
            if(c==strs.length) 
               return p;
            c=0;
        }
        return "";
    }
}

// Beats 78.39% --> 1ms runtime (using Trie)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String s:strs)
            insert(trie,s);
        StringBuilder sb = new StringBuilder();
        while(trie.count==1&&!trie.stop){
            trie = get(trie.a,sb);
        }
        return sb.toString();
    }

    private void insert(Trie trie,String s){
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null){
               trie.a[ch-'a']=new Trie();
               trie.count++;
            }
            trie = trie.a[ch-'a'];
        }
        trie.stop=true;
    }

    private Trie get(Trie[] a,StringBuilder sb){
        for(int i=0;i<26;i++){
            if(a[i]!=null){
               sb.append((char)(i+'a'));
               return a[i];
            }
        }
        return null;
    }
}


class Trie{
    Trie[] a;
    boolean stop;
    int count;
    public Trie(){
        this.a = new Trie[26];
        this.stop = false;
        this.count = 0;
    }
}
