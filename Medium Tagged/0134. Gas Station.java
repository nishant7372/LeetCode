//1ms runtime --> Beats 100%

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int startPoint=0;startPoint<gas.length;startPoint++)
        {
            if(gas[startPoint]>=cost[startPoint]){
            int endPoint = findEndPoint(startPoint,gas,cost);
                if(endPoint==startPoint)
                    return startPoint;
                if(startPoint>endPoint)
                    return -1;
                startPoint=endPoint;
            }
        }
        return -1;
    }

    // returns end point
    private int findEndPoint(int start,int[] gas,int[] cost)
    {
        int end=(start==gas.length-1)? 0:start+1;
        int remainingGas=gas[start]-cost[start];
        while(end!=start)
        {
            remainingGas+=gas[end]-cost[end];
            if(remainingGas<0)
                return end;
            end++;
            if(end==gas.length)
                end=0;
        }
        return start;
    } 
}

/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/

//Same code with short variables
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++)
        {
            if(gas[i]>=cost[i]){
            int a = check(i,gas,cost);
                if(a==i)
                    return i;
                if(i>a)
                    return -1;
                i=a;
            }
        }
        return -1;
    }

    private int check(int j,int[] gas,int[] cost)
    {
        int i=(j==gas.length-1)? 0:j+1;
        int remaining=gas[j]-cost[j];
        while(i!=j)
        {
            remaining+=gas[i]-cost[i];
            if(remaining<0)
            return i;
            i++;
            if(i==gas.length)
            i=0;
        }
        return j;
    } 
}
