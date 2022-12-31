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
