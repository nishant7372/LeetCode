class Solution {
    public int minimumOperations(int[] nums) {
        //the answer will be equal to unique non-zero integers in nums
        int[] freq = new int[101];
        for(int x:nums)
            freq[x]=1;
        int count=0;     //unique non-zero integer count
        for(int i=1;i<101;i++)
            if(freq[i]==1)
                count++;
        return count;
    }
}

// using one loop only -
class Solution {
    public int minimumOperations(int[] nums) {
        //the answer will be equal to unique non-zero integers in nums
        int[] freq = new int[101];
        int count=0;          //unique non-zero integer count
		freq[0]=1;
        for(int x:nums)
            if(freq[x]++==0)
                count++;
        return count;
	}
}
