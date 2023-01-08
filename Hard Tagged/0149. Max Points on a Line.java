class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        for(int[] x:points)
        {
            Map<Double,Integer> map= new HashMap<>();
            for(int[] y:points){
                if(x==y)
                  continue;
                
                double slope=0;
                if(y[0]-x[0]==0)
                   slope=Double.POSITIVE_INFINITY; 
                else
                   slope = (y[1]-x[1])/(double)(y[0]-x[0]);
                
                map.put(slope,map.getOrDefault(slope,0)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max+1;
    }
}
