// 26ms runtime Beats 75.25% (Without Trie)

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<List<String>>();
        Arrays.sort(products);
        for(int i=1;i<=searchWord.length();i++)
        {
            String t = searchWord.substring(0,i);
            ArrayList<String> temp= new ArrayList<String>();
            for(String s:products)
            {
                if(s.startsWith(t))
                   temp.add(s);
                if(temp.size()==3)
                   break;
            }
            list.add(temp);
        }
        return list;
    }
}

// 54ms runtime Beats 50% (Using Trie)

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<List<String>>();
        Trie trie = new Trie();
        for(String s:products)
            add(trie,s);

        for(char ch:searchWord.toCharArray())
        {
            if(trie.a[ch-'a']!=null){
               ArrayList<String> temp = new ArrayList<>();
               find(trie.a[ch-'a'],temp);
               list.add(temp);
               trie = trie.a[ch-'a'];
            }
            else
               break;
        }
        while(list.size()<searchWord.length())
           list.add(new ArrayList<>());
        return list;
    }

    private void add(Trie trie, String s)
    {
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null)
               trie.a[ch-'a'] = new Trie();
            trie = trie.a[ch-'a'];
        }
        trie.word=s;
    }

    private void find(Trie trie,ArrayList<String> list){
        if(trie.word!=null)
            list.add(trie.word);
        for(Trie t:trie.a){
            if(list.size()<3 && t!=null)
               find(t,list);
            if(list.size()==3)
               break;
        }
    }
}

class Trie{
    Trie a[];
    String word;

    public Trie(){
        this.a = new Trie[26];
        word=null;
    }
}
