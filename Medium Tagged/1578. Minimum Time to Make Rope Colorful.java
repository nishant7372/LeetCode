class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime=0;
        int i=0;
        while(i<colors.length()-1)
        {
            if(colors.charAt(i)==colors.charAt(i+1)){
                int j=i;
                int max=0;
                while(j<colors.length()-1 && colors.charAt(j)==colors.charAt(j+1)){
                    minTime+=neededTime[j];
                    if(neededTime[j]>max)
                        max=neededTime[j];
                    j++;
                }
                minTime+=neededTime[j];
                if(neededTime[j]>max)
                    max=neededTime[j];
                minTime-=max;
                i=j;
            }
            i++; 
        }
        return minTime;
    }
}
