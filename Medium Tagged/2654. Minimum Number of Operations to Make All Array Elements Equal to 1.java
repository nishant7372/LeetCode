class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (containsOne(nums)) {
            return n - countOne(nums);
        }
        int op = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int gcd = nums[i];
            for (int j = i+1; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    op = Math.min(op, j - i);
                    break;
                }
            }
        }
        return (op == Integer.MAX_VALUE) ? -1 : op + n - 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    private boolean containsOne(int[] nums){
        for(int x:nums){
            if(x==1){
                return true;
            }
        }
        return false;
    }
    
    private int countOne(int[] nums){
        int c=0;
        for(int x:nums){
            if(x==1){
                c++;
            }
        }
        return c;
    }
}
