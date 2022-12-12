class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        ArrayList<Integer>[] a = new ArrayList[vals.length];
        
        for(int i=0;i<vals.length;i++)
        {
            a[i] = new ArrayList<Integer>();
        }
        
        for(int[] x:edges)
        {
            if(vals[x[1]]>0)
            a[x[0]].add(vals[x[1]]);
            if(vals[x[0]]>0)
            a[x[1]].add(vals[x[0]]);
        }
        
        int max=Integer.MIN_VALUE;
        int j=0;
        for(ArrayList<Integer> list: a){
            Collections.sort(list,Collections.reverseOrder());
            int sum=vals[j++];
            for(int i=0;i<Math.min(list.size(),k);i++)
            {
                sum+=list.get(i);
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
