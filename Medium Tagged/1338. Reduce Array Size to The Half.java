class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x:arr)
        {
            if(map.get(x)==null)
                map.put(x,1);
            else
                map.put(x,map.get(x)+1);
        }
        
        ArrayList<Integer> a = new ArrayList<>(map.values());
        
        Collections.sort(a);
        
        int c=0;
        int sum=0;
        for(int i=a.size()-1;i>=0;i--)
        {
            sum+=a.get(i);
            c++;
            if(sum>=arr.length/2)
                return c;
        }
        return arr.length;
    }
}
