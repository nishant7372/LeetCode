class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Long> map = new HashMap<>();
        for(int x:arr)
        {
            long count=1;  //counting self
            for(int key:map.keySet())
            {
                if(x%key==0&&map.get(x/key)!=null)
                {
                count+=map.get(key)*map.get(x/key);  //counting left and right subtrees
                }
            }
            map.put(x,count);
        }
        long sum=0;
        for(long x:map.values())
        {
            sum=(sum+x)%(1000000007);
        }
        return (int)sum%(1000000007);
    }
}
