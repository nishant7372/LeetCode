class Solution {
    public List<String> letterCasePermutation(String s) {
        String t="";
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)>96)
                t+=(char)(s.charAt(i)-32);
            else if(s.charAt(i)>64)
                t+=(char)(s.charAt(i)+32);
            else 
                t+=s.charAt(i);
        generate(s,t,"",0,res);
        return res;
    }
    
    private void generate(String s,String t,String part,int index,ArrayList<String> res)
    {
        
        if(part.length()==s.length())
        {
            if(res.indexOf(part)==-1)
                res.add(part);
            return;
        }
        for(int i=index;i<s.length();i++)
        {
        generate(s,t,part+s.charAt(i),i+1,res);
        generate(s,t,part+t.charAt(i),i+1,res);
        }
    }
}
