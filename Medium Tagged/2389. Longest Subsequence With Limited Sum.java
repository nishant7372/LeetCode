class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
		
		//calculating prefix sum
        for(int i=1;i<nums.length;i++)
        {
            nums[i]+=nums[i-1];
        }
        for(int i=0;i<queries.length;i++)
        {
            int res = Arrays.binarySearch(nums,queries[i]);
            if(res>=0)
                queries[i]=res+1;
            else
                queries[i]=(-1*(res+1));  /*Arrays.binarySearch() returns index of the search key, if it is contained in the array;
				otherwise, (-(insertion point) - 1).*/
        }
        return queries;
    }
}
