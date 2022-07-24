class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] a = new int[4];
        for(char c:suits)
        {
            a[c-'a']++;
        }
        for(int x:a)
            if(x>=5)
                return "Flush";
        
        int[] b = new int[13];
        for(int x:ranks)
        {
            b[x-1]++;
        }
        boolean c2=false;
        boolean c3 =false;
        for(int x:b)
        {
            if(x>=3)
                c2=true;
            if(x>=2)
                c3=true;
        }
        if(c2)
            return "Three of a Kind";
        if(c3)
            return "Pair";
        return "High Card";
    }
}
