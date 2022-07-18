class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int i=0;
        ArrayList<String> temp;
        for(int[] a:queries)
        {
            temp = new ArrayList<>(nums.length);
            for(String s:nums)
            temp.add(s.substring(s.length()-(a[1]),s.length()));
            res[i++]=search(a[0],temp);
        }
        return res;
    }
    
    private int search(int pos,ArrayList<String> temp)
    {
        ArrayList<Integer> temp1;
        Map<String,ArrayList<Integer>> map = new TreeMap<>();
        int i=0;
        for(String x:temp)
        {
            if(map.get(x)==null)
            {
                temp1 = new ArrayList<>();
                temp1.add(i++);
                map.put(x,temp1);
            }     
            else
                map.get(x).add(i++);
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(ArrayList<Integer> list:map.values())
        {
            Collections.sort(list);
            for(int x:list)
                a.add(x);
        }
        return a.get(pos-1);
    }
}
