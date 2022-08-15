class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<s.length()-9;i++)
        {
            String t = s.substring(i,i+10);
            if(!set.contains(t))
                set.add(t);
            else if(!set2.contains(t))
                set2.add(t);
        }
        for(String t:set2)
            list.add(t);
        return list;
    }
}
