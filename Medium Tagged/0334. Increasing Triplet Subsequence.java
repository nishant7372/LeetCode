class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max=0;
        for(int x:nums)
        {
            if(max<x)
                max=x;
        }
        int smallest = max;
        int smaller = max;
        for(int x:nums)
        {
            if(smallest>=x)
                smallest=x;
            else if(smaller>=x)
                smaller=x;
            else
                return true;
        }
        return false;
    }
}
