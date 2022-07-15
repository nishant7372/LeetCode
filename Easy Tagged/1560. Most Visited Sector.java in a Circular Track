class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] a = new int[n+1];
        for(int i=0;i<rounds.length-1;i++)
        {
            calc(rounds[i+1],rounds[i],a,n);
        }
        a[rounds[rounds.length-1]]++;
        int max=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>a[max])
            {
              max=i;  
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==a[max])
            {
              list.add(i);  
            }
        }
        return list;
    }
    
    private void calc(int end,int start,int[] a,int n)
    {
        int i=start;
        while(i!=end)
        {
            a[i]++;
            if(i==n)
                i=0;
            i++;
        }
    }
}
