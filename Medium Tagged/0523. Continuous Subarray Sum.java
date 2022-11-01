class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(0,0);
        int sum=0;
        int i=0;
        for(int x:nums)
        {
            sum+=x;
            int rem=sum%k;
            if(map.get(rem)==null)
                map.put(rem,i+1);
            else if(map.get(rem)<i)
                return true;
            i++;
        }
        return false;
    }
}
