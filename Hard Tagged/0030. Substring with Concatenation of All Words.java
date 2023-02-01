class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int wordLen = words.length*words[0].length();

        Map<String,Integer> map = new HashMap<>();
        for(String w:words)
            map.put(w,map.getOrDefault(w,0)+1);
        
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length()-wordLen+1;i++)
        {
            if(check(arr,i,i+wordLen,new HashMap<>(map),words[0].length()))
                list.add(i);  
        }
        return list;
    }
    
    private boolean check(char[] arr,int start,int end,Map<String,Integer> map,int gap)
    {   
        for(int i=start;i<end;i+=gap)
        {
            String t = String.valueOf(arr,i,gap);
            if(map.get(t)!=null && map.get(t)>0)
               map.put(t,map.get(t)-1);
            else
               return false;
        }
        for(int x:map.values()){
            if(x!=0)
                return false;
        }
        return true;
    }
}
