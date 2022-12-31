class Solution {
    public int captureForts(int[] a) {
        int n = a.length;
    
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(a[i]!=0)
             list.add(i);   
        }
        int max=0;
        for(int i=0;i<list.size()-1;i++)
        {
            if(a[list.get(i)]==-1*a[list.get(i+1)])
                max=Math.max(max,list.get(i+1)-list.get(i)-1);
        }
        return max;
    }
}
