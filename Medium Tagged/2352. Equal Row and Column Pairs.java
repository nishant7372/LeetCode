class Solution {
    public int equalPairs(int[][] grid) {
        ArrayList<int[]> col = new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            int[] temp=new int[grid.length];
            for(int j=0;j<grid.length;j++)
            {
                temp[j]=grid[j][i];
            }
            col.add(temp);
        }
        int c=0;
        for(int[] x:grid)
        {
            for(int[] y:col)
            {
                if(Arrays.equals(x,y))
                    c++;
            }
        }
        return c;
    }
}
