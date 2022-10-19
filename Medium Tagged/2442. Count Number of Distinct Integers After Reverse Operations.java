class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
            set.add(reverse(x,0));
        }
        return set.size();
    }
    
    private int reverse(int n,int rev)
    {
        if(n==0)
            return rev;
        return reverse(n/10,rev*10+n%10);
    }
}
