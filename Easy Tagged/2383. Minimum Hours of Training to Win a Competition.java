class Solution {
    public int minNumberOfHours(int inEnergy, int inExp, int[] energy, int[] experience) {
        int sum=0;
        int add=0;
        for(int i=0;i<energy.length;i++)
        {
            sum+=energy[i];
            if(inExp>experience[i])
                inExp+=experience[i];
            else{
                add+=experience[i]-inExp+1;
                inExp+=experience[i]+add;
            }
        }
        if(sum>=inEnergy)
            return add + sum-inEnergy+1;
        else
            return add;
    }
}
