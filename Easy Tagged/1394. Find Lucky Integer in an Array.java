class Solution {
    public int findLucky(int[] arr) {
        int max=0;
        for(int x:arr)
        {
            if(x>max)
                max=x;
        }
        int[] a = new int[max+1];
        
        for(int x:arr)
            a[x]++;
    
        for(int i=a.length-1;i>0;i--)
        {
            if(a[i]==i)
            return i;
        }
        return -1;
    }
}
