class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        int wordLen = words.length*words[0].length();
        
        for(int i=0;i<s.length()-wordLen+1;i++)
        {
            if(check(s,i,i+wordLen,words))
                list.add(i);  
        }
        return list;
    }
    
    private boolean check(String s,int start,int end,String[] words)
    {
        Map<String,Integer> map = new HashMap<>();
        for(String w:words)
        {
            if(map.get(w)!=null)
               map.put(w,map.get(w)+1);
            else
               map.put(w,1);
        } 
        int gap = words[0].length();
        for(int i=start;i<end;i+=gap)
        {
            String t = s.substring(i,i+gap);
            if(map.get(t)!=null)
               map.put(t,map.get(t)-1);
            else
               return false;
            if(map.get(t)<0)
                return false;
        }
        for(int x:map.values())
        {
            if(x!=0)
                return false;
        }
        return true;
    }
}
