class Solution {
    char[][] pairs = {{'a','b','c'},
                      {'d','e','f'},
                      {'g','h','i'},
                      {'j','k','l'},
                      {'m','n','o'},
                      {'p','q','r','s'},
                      {'t','u','v'},
                      {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
    ArrayList<String> main = new ArrayList<String>();
    if(digits.length()==0)
        return main;
    combine(digits,main,"");    
        return main;
    }
    
    private void combine(String digits, ArrayList<String> main, String part)
    {
        if(part.length()==digits.length())
        {
            main.add(part);
            return;
        }
        for(char c: pairs[digits.charAt(part.length())-'2'])
          combine(digits,main,part+c);
    }
}
