class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet = new int[26];
        
        for(int i=0;i<order.length();i++)
            alphabet[order.charAt(i)-'a']=i;
        
        for(int i=1;i<words.length;i++)
        {
          if(words[i].length()<words[i-1].length()&&words[i-1].startsWith(words[i]))
            return false;
            
           for(int j=0;j<Math.min(words[i].length(),words[i-1].length());j++)
           {
               int currIndex = alphabet[words[i].charAt(j)-'a'];
               int prevIndex = alphabet[words[i-1].charAt(j)-'a'];
               
               if(prevIndex>currIndex)
                   return false;
               if(currIndex>prevIndex)
                   break;
           }   
        }
        return true;
    }
}
