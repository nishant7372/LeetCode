class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int collectionTime = 0;
        int total=0;
        int PTtravel = 0;  //time taken to travel by Paper Truck
        int GTtravel = 0;  //time taken to travel by Glass Truck
        int MTtravel =0;   //time taken to travel by Metal Truck
        int prevPT=0;   //time taken to travel Paper Truck till last Position
        int prevPG=0;   //time taken to travel Glass Truck till last Position
        int prevPM=0;   //time taken to travel Metal Truck till last Position
        for(int i=0;i<garbage.length;i++)
        {
            if(i>0)
            total+=travel[i-1]; //pefix-sum of travelling time
            
            if(garbage[i].indexOf('P')>=0)
            {
                PTtravel+=total-prevPT;
                prevPT=PTtravel;
            }
            if(garbage[i].indexOf('G')>=0)
            {
                GTtravel+=total-prevPG;
                prevPG=GTtravel;
            }
            if(garbage[i].indexOf('M')>=0)
            {
                MTtravel+=total-prevPM;
                prevPM=MTtravel;
            } 
            collectionTime+=garbage[i].length();  //time to collect garbage from ith house
        }
        return collectionTime+PTtravel+GTtravel+MTtravel;
    }
}
