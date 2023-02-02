class MagicDictionary {
    String[] dict;
    public MagicDictionary() {

    }
    
    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        for(String s:dict)
        {
            if(s.length()!=searchWord.length())
                continue;
            else
            {
               int c=0; 
               for(int i=0;i<s.length();i++){
                   if(s.charAt(i)!=searchWord.charAt(i))
                       c++;
               }
               if(c==1)
                  return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
