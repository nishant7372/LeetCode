class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer,Long> map = new HashMap<>();
        int mod = 1000000007;
        for(int x:nums)
        {
            int a = x-rev(x);
            map.put(a,map.getOrDefault(a,0L)+1);
        }
        long sum=0;
        for(long x:map.values())
        {
            sum+=(x*(x-1))/2;
            sum=sum%mod;
        }
        
        return (int)sum;
    }
    
    
    private int rev(int n)
    {
        int rev=0;
        while(n>0)
        {
            rev=rev*10+n%10;
            n/=10;
        }
        return rev;
    }
}
