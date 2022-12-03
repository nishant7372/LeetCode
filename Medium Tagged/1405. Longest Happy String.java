class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,b1) -> Integer.compare(b1[0],a1[0]));
        if(a!=0)
        pq.add(new int[]{a,97});
        if(b!=0)
        pq.add(new int[]{b,98});
        if(c!=0)
        pq.add(new int[]{c,99});
        StringBuffer sb = new StringBuffer();

        while(pq.size()>1)
        {
            int[] f = pq.remove();
            int[] s = pq.remove();
            
            if(f[0]>=2){
                sb.append(((char)f[1]+"").repeat(2));
                f[0]-=2;
            }
            else{
                sb.append((char)f[1]+"");
                f[0]-=1;
            }
            if(f[0]<s[0] && s[0]>=2){
                sb.append(((char)s[1]+"").repeat(2));
                s[0]-=2;
            }
            else{
                sb.append((char)s[1]+"");
                s[0]-=1;
            }  
            if(s[0]>0)
            pq.add(s);
            if(f[0]>0)
            pq.add(f);
        }
        if(!pq.isEmpty())
        {
            int[] f = pq.remove();
            sb.append(((char)f[1]+"").repeat(Math.min(f[0],2)));
        }
        return sb.toString();
    }
}
