class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] a = new int[101]; //pattern array
        int[] b = new int[101]; //frequency count array
        for(int i=2;i<101;i++)
            a[i]=a[i-1]+(i-1);
        for(int x:nums)
            b[x]++;
        int c=0; //number of pairs
        for(int x:b)
            c+=a[x]; 
        return c;
    }
}
