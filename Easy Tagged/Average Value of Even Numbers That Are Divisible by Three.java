class Solution {
    public int averageValue(int[] nums) {
        
        int sum=0;
        int c=0;
        for(int x:nums)
        {
            if(x%2==0 && x%3==0){
                sum+=x;
                c++;
            }
        }
        if(c==0 || sum==0)
            return 0;
        return sum/c;
    }
}
