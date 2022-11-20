class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int res=0;
        
        for(int i=0;i<nums.length;i++)
        {
            int lcm = nums[i];
            for(int j=i;j<nums.length;j++)
            {
                lcm = lcm(lcm,nums[j]);
                if(lcm==k)
                    res++;
                if(lcm>k)
                    break;
            }
        }
        return res;
    }
    
    private int lcm(int a,int b)
    {
        return (a/gcd(a,b))*b;
    }
    
    private int gcd(int a,int b)
    {
        if(a==0)
            return b;
        return gcd(b % a, a);
    }
}
