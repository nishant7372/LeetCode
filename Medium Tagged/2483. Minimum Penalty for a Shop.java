class Solution {
    public int bestClosingTime(String customers) {
        int max=0;
        int c=0;
        int maxi=-1;
        for(int i=0;i<customers.length();i++)
        {
            if(customers.charAt(i)=='Y')
                c++;
            else
                c--;
            if(max<c){
                max=c;
                maxi=i;
            }
        }
        return maxi+1;
    }
}
