class Solution {
    public String oddString(String[] words) {
        int j=0;
        Map<String,ArrayList<Integer>> map= new HashMap<>();
        for(String s:words)
        {
            StringBuffer sb = new StringBuffer();
            for(int i=1;i<s.length();i++)
            {
                sb.append((s.charAt(i)-s.charAt(i-1))+",");
            }
            
            if(map.get(sb.toString())==null)
            {
                map.put(sb.toString(),new ArrayList<Integer>());
            }
            map.get(sb.toString()).add(j);
            j++;
        }
        
        for(ArrayList<Integer> temp:map.values())
        {
            if(temp.size()==1)
                return words[temp.get(0)];
        }
        return "";
    }
}
