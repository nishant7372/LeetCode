class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int c=0;
        for(int x:nums)
        {
            if(x==k)
                c++;
        }
        int j=1;
        while(j!=nums.length)
        {
        for(int i=0;i<nums.length-j;i++)
        {
            if(nums[i]==1||nums[i+1]==1)
                nums[i]=1;
            else
                nums[i]=gcd(nums[i],nums[i+1]);
            if(nums[i]==k){
                c++;
            }
        }
            j++;
        }
        return c;
    }
    
    private int gcd(int a,int b)
    {
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a==b)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(a,b-a);
    }
}
