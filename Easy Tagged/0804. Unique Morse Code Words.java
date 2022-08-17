class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set= new HashSet<>();
        for(String x:words)
        {
           String s = "";
           for(int i=0;i<x.length();i++) 
               s+=morse[x.charAt(i)-'a'];
           set.add(s);   
        }
        return set.size();
    }
}
