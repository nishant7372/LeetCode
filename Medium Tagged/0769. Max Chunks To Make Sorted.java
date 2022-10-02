class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] a = new int[10];
        
        for(int i=0;i<arr.length;i++)
            a[arr[i]] = i;
        
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            boolean increaseCount=true;
            for(int j=0;j<=i;j++)
            {
                if(a[j]>i)
                {
                    increaseCount=false;
                    break;
                }
            }
            if(increaseCount)
                c++;
        }
        return c;
    }
}
