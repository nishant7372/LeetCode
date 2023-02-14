// Method 1 --> Sorting + Binary Search
// 2ms runtime, Beats 84%

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();
        int lower = lowerBound(nums,target);
        int upper = upperBound(nums,target);
        for(int i=lower;i<=upper;i++){
            res.add(i);
        }
        return res;
    }

    public int lowerBound(int[] arr,int target){
        if(arr.length==0)
            return 0;
        int i=0;
        int j=arr.length-1;

        while(i<=j){
            int mid = (i+j)/2;  // mid = i+ (j-i)/2

            if(arr[mid]>=target)
                j=mid-1;
            else
                i=mid+1;
        }
        return i;
        // i = insertionIndex || targetIndex
        // j = insertionIndex-1 || targetIndex-1
    }

    public int upperBound(int[] arr,int target){
        if(arr.length==0)
            return 0;
        int i=0;
        int j=arr.length-1;

        while(i<=j){
            int mid = (i+j)/2;  // mid = i+ (j-i)/2

            if(arr[mid]<=target)
                i=mid+1;
            else
                j=mid-1;
        }
        return j;
        // i = insertionIndex || targetIndex+1
        // j = insertionIndex-1 || targetIndex
    }
}

// Method 2 --> Linear Search
// 3ms runtime, Beats 24%

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> a= new ArrayList<Integer>();
        Arrays.sort(nums);
        int i=0;
        for(int x: nums)
        {
            if(x==target)
                a.add(i);
            i++;
        }
        return a;
    }
}
