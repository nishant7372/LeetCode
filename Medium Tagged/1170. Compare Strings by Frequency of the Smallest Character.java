class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wFreq = new int[words.length];
        int[] qFreq = new int[queries.length];
        
        int i=0;
        for(String s:words)
        {
            wFreq[i++] = calc(s);
        }
        i=0;
        for(String s:queries)
        {
            int c=0;
            int freq = calc(s);
            for(int x:wFreq)
            {
                if(x>freq)
                    c++;
            }
            qFreq[i++]=c;
        }
        return qFreq;
    }
    
    
    private int calc(String s)
    {
       char min='z';
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)<min)
               min=s.charAt(i);
       }
        int c=0;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)==min)
              c++;
       } 
        return c;
    }
}
