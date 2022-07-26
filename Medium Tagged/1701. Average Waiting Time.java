class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time=0;
        long sum=0;
        for(int i=0;i<customers.length;i++)
        {
            if(time<customers[i][0])
                time+=customers[i][0]-time;
            time+=customers[i][1];
            sum+=time-customers[i][0];
        }
        return (double)sum/customers.length;
    }
}
