class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        int i=0;
        for(int x: spells)
            res[i++]=potions.length-search(potions,(int)Math.ceil((double)success/x));
        
        return res;
    }
    
    private int search(int[] potions,int k)
    {
        int i=0;
        int j=potions.length;
        
        while(i<j)
        {
            int mid = (i+j)/2;
            
            if(potions[mid]<k)
                i=mid+1;
            else
                j=mid;
        }
        return j;
    }
}
