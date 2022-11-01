class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int max=0;
        for(int x:barcodes)
        {
            if(x>max)
                max=x;
        }
        int[][] a = new int[max+1][2];
        
        for(int x:barcodes){
            a[x][1]++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1,b1)-> a1[1]==b1[1]? Integer.compare(a1[0],b1[0]):Integer.compare(b1[1],a1[1]));
            
        int i=0;
        for(int[] x:a)
        {
            if(x[1]>0){
                x[0]=i;
                queue.add(x);
            }
            i++;
        }
        
        int[] prev=null;
        i=0;
        while(i<barcodes.length)
        {
            if(queue.isEmpty()){
                queue.add(prev);
                prev=null;
            } 
            int[] curr = queue.remove();
            curr[1]--;
            barcodes[i++]=curr[0];
            
            if(prev!=null && prev[1]!=0)
                queue.add(prev);
            prev=curr;
        }
        return barcodes;
    }
    
}
