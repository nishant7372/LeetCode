class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];
        
        for(int i=0;i<time.length;i++)
        {
            time[i] = (double)dist[i]/speed[i];
        }
        
        //Sorting monsters on the basis of time
        Arrays.sort(time);
        
        int min=0;   // time(minutes) passed
        int eliminated=0;   //no. of monsters eliminated
        for(double x:time)
        {
            if(x<=min)
                return eliminated;
            eliminated++;
            min++;
        }
        return eliminated;
    }
}
