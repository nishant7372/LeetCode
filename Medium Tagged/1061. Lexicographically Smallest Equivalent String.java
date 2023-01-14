// Union-Find Beats 100%

class Solution {
    int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for(int i=0;i<26;i++)
            parent[i]=i;
        for(int i=0;i<s1.length();i++){
            int u = find(s1.charAt(i)-'a');
            int v = find(s2.charAt(i)-'a');
            if(u<v)
              parent[v]=u;
            else if(u>v)
              parent[u]=v;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++)
            sb.append((char)(find(baseStr.charAt(i)-'a')+'a'));
        return sb.toString();
    }

    private int find(int u){
        return parent[u]==u? u:find(parent[u]);
    }
}


//  Brute-Force --> HashTable Beats 90% (Time Optimized Brute Force)

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] smallest = new char[26];  //smallest for each character
        ArrayList<SetMaker> a = new ArrayList<>();
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                continue; 
            connect(s1.charAt(i),s2.charAt(i),a);
        }

        //filling smallest array with default values
        for(int i=0;i<26;i++)
            smallest[i]=(char)(i+'a');
        
        //for characters of each set mapping smallest to characters
        for(SetMaker sm:a){
            for(int i=0;i<26;i++){
                if(sm.set[i]==1)
                smallest[i]=sm.smallest;
            }
        }

        //building resultant string from baseString
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++)
            sb.append(smallest[baseStr.charAt(i)-'a']);
        
        return sb.toString();
    }

    private void connect(char ch1,char ch2,ArrayList<SetMaker> a)
    {
        SetMaker sm1=null;
        SetMaker sm2=null;
        for(SetMaker sm:a){  //searching characters in Sets
            if(sm.set[ch1-'a']==1)
               sm1=sm;
            if(sm.set[ch2-'a']==1)
               sm2=sm;
        }
        if(sm1==null && sm2==null){  //if no character found
            int[] set= new int[26];
            set[ch1-'a']=1;
            set[ch2-'a']=1;
            char smallest = ch1<ch2? ch1:ch2;
            a.add(new SetMaker(set,smallest));
        }
        else if(sm1==null){  //if only charcter1 found
           sm2.set[ch1-'a']=1;
           if(sm2.smallest>ch1) 
              sm2.smallest=ch1;
        }
        else if(sm2==null){  //if only character2 found
           sm1.set[ch2-'a']=1;
           if(sm1.smallest>ch2)
              sm1.smallest=ch2;
        }
        
        //joining two sets when a==b and both a and b are in different sets
        if(sm1!=null && sm2!=null && sm1!=sm2){ 
        for(int i=0;i<26;i++){
            if(sm2.set[i]==1){
               sm1.set[i]=1;
            if(sm1.smallest>(char)(i+'a'))
               sm1.smallest=(char)(i+'a');
            }
        }
        sm2.set=new int[26]; //removing one of the sets after joining
        }
    }
}

class SetMaker{
    int[] set;
    char smallest;
    public SetMaker(int[] set,char smallest){
        this.set=set;
        this.smallest=smallest;
    }
}

//  Brute Force --> HashSet Beats 70% (Space Optimized Brute Force)

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] smallest = new char[26];  //smallest for each character
        ArrayList<SetMaker> a = new ArrayList<>();
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                continue; 
            connect(s1.charAt(i),s2.charAt(i),a);
        }

        //filling smallest array with default values
        for(int i=0;i<26;i++)
            smallest[i]=(char)(i+'a');
        
        //for characters of each set mapping smallest to characters
        for(SetMaker sm:a){
            for(char x:sm.set){
                smallest[x-'a']=sm.smallest;
            }
        }

        //building resultant string from baseString
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++)
            sb.append(smallest[baseStr.charAt(i)-'a']);
        
        return sb.toString();
    }

    private void connect(char ch1,char ch2,ArrayList<SetMaker> a)
    {
        SetMaker sm1=null;
        SetMaker sm2=null;
        for(SetMaker sm:a){  //searching characters in Sets
            if(sm.set.contains(ch1))
               sm1=sm;
            if(sm.set.contains(ch2))
               sm2=sm;
        }
        if(sm1==null && sm2==null){  //if no character found
            Set<Character> set= new HashSet<>();
            set.add(ch1);
            set.add(ch2);
            char smallest = ch1<ch2? ch1:ch2;
            a.add(new SetMaker(set,smallest));
        }
        else if(sm1==null){  //if only charcter1 found
           sm2.set.add(ch1);
           if(sm2.smallest>ch1) 
              sm2.smallest=ch1;
        }
        else if(sm2==null){  //if only character2 found
           sm1.set.add(ch2);
           if(sm1.smallest>ch2)
              sm1.smallest=ch2;
        }
        
        //joining two sets when a==b and both a and b are in different sets
        if(sm1!=null && sm2!=null && sm1!=sm2){ 
        for(char ch:sm2.set){
            sm1.set.add(ch);
            if(sm1.smallest>ch)
               sm1.smallest=ch;
        }
        sm2.set=new HashSet<>(); //removing one of the sets after joining
        }
    }
}

class SetMaker{
    Set<Character> set;
    char smallest;
    public SetMaker(Set<Character> set,char smallest){
        this.set=set;
        this.smallest=smallest;
    }
}

// Depth First Search --> Beats 50% 

class Solution {
    boolean[] visited;
    Character[] smallest;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        smallest = new Character[26];
        ArrayList<Character>[] a = new ArrayList[26];
        for(int i=0;i<26;i++){
            a[i]=new ArrayList<Character>();
        }
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a'].add(s2.charAt(i));
            a[s2.charAt(i)-'a'].add(s1.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<baseStr.length();i++){
            visited = new boolean[26];
            sb.append(smallest[baseStr.charAt(i)-'a']=dfs(baseStr.charAt(i),a));
        }
        return sb.toString();
    }

    private Character dfs(Character curr,ArrayList<Character>[] a)
    {
        if(smallest[curr-'a']!=null)
           return smallest[curr-'a'];
        Character small=curr;
        for(Character ch:a[curr-'a']){
            if(!visited[ch-'a']){
                visited[ch-'a']=true;
                Character res = dfs(ch,a);
                if(res<small)
                   small=res;
            }
        }
        return small;
    }
}
