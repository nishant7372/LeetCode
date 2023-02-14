// 2ms runtime, Beats 98% 
// Greedy + Counting Sort 

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max=0;
        for(int[] x:boxTypes){
            max=Math.max(max,x[1]);
        }

        int[] a = new int[max+1]; 
        
        for(int[] x:boxTypes)
            a[x[1]]+=x[0];
        
        int boxes=0, units=0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(boxes+a[i]<=truckSize){
               units+=i*a[i];
               boxes+=a[i];
            }
            else{
                units+=i*(truckSize-boxes); //units in boxType i * remaining boxes 
                return units;
            }
        }
        return units;
    }
}
