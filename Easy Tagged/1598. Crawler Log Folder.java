class Solution {
    public int minOperations(String[] logs) {
        int c=0;
        for(String s:logs)
        {
            if(s.length()==2)
            {
                if(!s.endsWith("./"))
                    c++;
            }
            else
            {
                 if(s.endsWith("../"))
                 {
                     if(c>0)
                         c--;
                 }
                 else if(!s.endsWith("./"))
                    c++;
            }
        }
        return c;
    }
}
