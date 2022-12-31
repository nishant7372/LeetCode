class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int i = startIndex;
        int n = words.length;
        int c=0;
        int min=Integer.MAX_VALUE;
        if(!check(words,target))
            return -1;
        while(i!=startIndex-1)
        {
            if(words[i].equals(target))
                break;
            c++;
            i++;
            if(i==n)
                i=0;
        }
        if(i!=startIndex-1)
        {
            min=Math.min(min,c);
        }
        i=startIndex;
        c=0;
        while(i!=startIndex+1)
        {
            if(words[i].equals(target))
                break;
            i--;
            c++;
            if(i==-1)
                i=n-1;
        }
        if(i!=startIndex+1)
        min=Math.min(min,c);
        return min;
    }
    
    
    private boolean check(String[] words,String target)
    {
        for(String x:words)
        {
            if(x.equals(target))
                return true;
        }
        return false;
    }
}
