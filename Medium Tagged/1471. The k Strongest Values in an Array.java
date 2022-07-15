class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = (arr.length-1)/2;
        int i=0;
        int j=arr.length-1;
        int[] a = new int[k];
        int index=0;
        
        while(i<=m||j>=m)
        {
            if(arr[m]-arr[i]>arr[j]-arr[m])
                a[index++]=arr[i++];
            
            else
                a[index++]=arr[j--];
            
            if(index==k)
                break;
        }
        return a;
    }
}
