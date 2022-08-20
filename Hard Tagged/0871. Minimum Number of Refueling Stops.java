Approach Used -
1. Initailly take max Reachable Distance (maxDist) = startFuel;
2. while ( maxReachableDistance < target)
-->> a. search for fuel station with maxFuel (within Range of Max Reachable Distance) and add the Fuel to maxReachableDistance.
-->> b. increment stops
3. if at any point no station is available to refuel (within Range of Max Reachable Distance) -> return -1

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {  
        int stops = 0;
        int maxReach = startFuel;
        while(maxReach<target)
        {
            int maxFuel = max(maxReach,stations);
            if(maxFuel==0)    // If no station is available to refuel 
                return -1;
            maxReach+=maxFuel;
            stops++;
        }
        return stops;
    }
    
    private int max(int maxReach, int[][] stations)
    {
        int maxFuel=0;
        int[] temp = null; 
        for(int i=0;i<stations.length&&stations[i][0]<=maxReach;i++)  //searching for fuel station with maxFuel in range of Max Reachable Distance
        {
            if(stations[i][1]>maxFuel)
            {
             temp = stations[i];
             maxFuel=stations[i][1];
            }   
        }
        if(temp!=null)
        temp[1]=0;    //all the fuel used up in refueling
        return maxFuel;
    }
}
