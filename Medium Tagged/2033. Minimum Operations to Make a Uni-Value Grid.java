class Solution {
    public int minOperations(int[][] grid, int x) {
       ArrayList<Integer> list = new ArrayList<Integer>(grid.length*grid[0].length);
       for(int[] m:grid)
       {
           for(int y:m)
           {
               list.add(y);
           }
       }
        Collections.sort(list);
       int median = list.get(list.size()/2);

        int c=0;
        for(int l:list)
        {
           if(median%x==l%x)
           {
               c+=Math.abs(Math.abs(median-l)/x);
           }
            else
                return -1;
        }
        return c;
    }
}
