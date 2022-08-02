class Solution {
    public int minimumOperations(int[] nums) {
        //the answer will be equal to unique non-zero integers in nums
        int[] a = new int[101];
        for(int x:nums)
            a[x]=1;
        int c=0;
        for(int x:a)
            if(x==1)
                c++;
        return a[0]==1? c-1:c;
    }
}
