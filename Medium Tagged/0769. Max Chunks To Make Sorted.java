// Method 1 -> O(n) time and O(n) space, Beats 100%  

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        int m = Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            m = Math.min(m,arr[i]);
            min[i] = m;
        }

        int c=1, max=0;

        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,arr[i]);
            if(max<=min[i+1])
                c++;
        }
        return c;
    }
}


// Method 2 -> Beats 100%

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
                if(a[j]>i){
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
