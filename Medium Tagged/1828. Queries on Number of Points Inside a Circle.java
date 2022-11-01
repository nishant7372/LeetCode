class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        
        int i=0;
        for(int[] query:queries)
        {
            res[i++]=calculate(query,points);
        }
        return res;
    }
    
    private int calculate(int[] query, int[][] points)
    {
        int r = query[2];
        int c=0;
        for(int[] point: points)
        {
            int x = point[0]-query[0];
            int y = point[1]-query[1];
            
            if(x*x+y*y<=r*r)
                c++;
        }
        return c;
    }
}
