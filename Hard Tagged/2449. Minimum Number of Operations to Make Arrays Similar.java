class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int even=0;
        for(int x:nums)
        {
            if(x%2==0)
                even++;
        }
        int[] numsOdd = new int[nums.length-even];
        int[] targetOdd = new int[target.length-even];
        int[] numsEven = new int[even];
        int[] targetEven = new int[even];
        
        int j,k,a,b;
        j=k=a=b=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
                numsEven[j++]=nums[i];
            else
                numsOdd[k++]=nums[i];
            if(target[i]%2==0)
                targetEven[a++]=target[i];
            else
                targetOdd[b++]=target[i];
            
        }
        Arrays.sort(numsOdd);
        Arrays.sort(numsEven);
        Arrays.sort(targetOdd);
        Arrays.sort(targetEven);
        long sum=0;
        for(int i=0;i<numsOdd.length;i++)
        {
            sum+=Math.abs(numsOdd[i]-targetOdd[i]);
        }
        for(int i=0;i<numsEven.length;i++)
        {
            sum+=Math.abs(numsEven[i]-targetEven[i]);
        }
        return sum/4;
    } 
}
