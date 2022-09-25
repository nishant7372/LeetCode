class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int j=0;j<heights.length;j++)
        {
            int max=j;
            for(int i=j;i<heights.length;i++)
            {
            if(heights[i]>heights[max])
                max = i;
            }
            swapNames(names,max,j);
            swapHeights(heights,max,j);
        }
        return names;
    }
    
    
    private void swapNames(String[] names,int i,int j)
    {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }
    
    private void swapHeights(int[] heights,int i,int j)
    {
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;
    }
}
