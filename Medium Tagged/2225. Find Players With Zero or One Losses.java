class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> winner = new ArrayList<Integer>();
        ArrayList<Integer> loser = new ArrayList<Integer>();
        int max=0;
        for(int i=0;i<matches.length;i++)
        {
            if(max<matches[i][0])
                max=matches[i][0];
            if(max<matches[i][1])
                max=matches[i][1];
        }
        int[] a = new int[max+1];
        int[] b = new int[max+1];
        for(int i=0;i<matches.length;i++)
        {
            a[matches[i][1]]++;
            b[matches[i][0]]++;
        }
        for(int i=0;i<b.length;i++)
        {
            if(b[i]>=1&&a[i]==0)
            winner.add(i);
            if(a[i]==1)
            loser.add(i);
        }    
        list.add(winner);
        list.add(loser);
        return list;
    }
}
