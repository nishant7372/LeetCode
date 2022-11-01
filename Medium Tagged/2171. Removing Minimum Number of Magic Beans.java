class Solution {
    public long minimumRemoval(int[] beans) {
        int max=0;
        for(int x:beans)
            if(x>max)
                max=x;
    
        int[] a = new int[max+1];
        long total=0;
        
        for(int x:beans){
            total+=x;
            a[x]++;
        }
        
        long min=Long.MAX_VALUE;
        int i=0;
        int freq=0;
        for(int x:a)
        {
            if(x>0){
            long res=(total-i)-((long)(beans.length-1-freq)*i);
            if(min>res)
                min=res;
            freq+=x;
            }
            i++;
        }
        return min;
    }
}
