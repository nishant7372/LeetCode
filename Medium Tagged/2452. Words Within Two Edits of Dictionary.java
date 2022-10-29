class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<String>();
        for(String s:queries)
        {
            if(check(s,dictionary))
                list.add(s);
        }
        return list;
    }
    
    private boolean check(String s,String[] dict)
    {
        for(String x:dict)
        {
            int c=0;
            for(int i=0;i<x.length();i++)
            {
                if(x.charAt(i)!=s.charAt(i))
                    c++;
            }
            if(c<=2)
                return true;
        }
        return false;
    }
}
