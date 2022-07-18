class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
    int gcd = calcGCD(numsDivide);
        
    Arrays.sort(nums);
    
    int i=0;
    while(i<nums.length&&gcd%nums[i]!=0)
        i++;
        
    return i==nums.length? -1:i;
        
    }
    
    private int GCD(int a, int b)
    {
        if (a == 0)
            return b;
        return GCD(b % a, a);
    }
 
    private int calcGCD(int[] nums)
    {
        int gcd = nums[0];
        for (int x: nums){
            gcd = GCD(gcd, x);
 
            if(gcd == 1)
               return 1;
        }
 
        return gcd;
    }
}
