class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list =new  ArrayList<List<Integer>>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] x:items1)
        {
            map.put(x[0],x[1]);
        }
        for(int[] x:items2)
        {
            if(map.get(x[0])!=null)
            map.put(x[0],map.get(x[0])+x[1]);
            else
            map.put(x[0],x[1]);
        }
        for(int i=0;i<map.values().size();i++)
            list.add(new ArrayList<Integer>());
        int i=0;
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int x:keys)
        {
            list.get(i).add(x);
            list.get(i).add(map.get(x));
            i++;
        }
        return list;
    }
}
