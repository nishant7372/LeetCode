class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] a;
        int[] prev = new int[26];
        ArrayList<String> res = new ArrayList<String>();
        for(String w:words2)
        {
            a = new int[26];
            for(int i=0;i<w.length();i++)
            {
                a[w.charAt(i)-'a']++;
            }
            for(int i=0;i<prev.length;i++)
            {
                prev[i]=Math.max(prev[i],a[i]);
            }
        }
        for(String w:words1)
        {
            a=new int[26];
            if(check(w,a,prev))
                res.add(w);
        }
        return res;
    }
    
    private boolean check(String w,int[] a,int[] prev)
    {
            for(int i=0;i<w.length();i++)
            {
                a[w.charAt(i)-'a']++;
            }
            for(int i=0;i<prev.length;i++)
            {
               if(a[i]<prev[i])
                   return false;
            }
        return true;
    }
}
