class Solution {
    public int arrayPairSum(int[] nums) {
        int max=-10001;
        int min=10001;
        for(int x:nums)
        {
            if(max<x)
                max=x;
            if(min>x)
                min=x;
        }
        int[] a = new int[max-min+1];
        for(int x:nums)
            a[x-min]++;
        int sum=0;
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            while(a[i]-->0){
                nums[j++]=i+min;
                if((j-1)%2==0)
                    sum+=nums[j-1];
            }
        }
        return sum;
    }
}
