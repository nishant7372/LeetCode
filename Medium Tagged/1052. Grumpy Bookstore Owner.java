class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int Csum=0;
        int total=0;
        int max=0;
        for(int i=0;i<minutes;i++)
        {
            if(grumpy[i]==1){
                Csum+=customers[i];
            }
            else{
                total+=customers[i];
            }
        }
        if(Csum>max)
            max=Csum;
        for(int i=minutes;i<grumpy.length;i++)
        {
            if(grumpy[i]==1){
                Csum+=customers[i];
            }
            else{
                total+=customers[i];
            }
            if(grumpy[i-minutes]==1)
                Csum-=customers[i-minutes];
            if(Csum>max){
                max=Csum;
            }
        }
        return total+max;
    }
}
