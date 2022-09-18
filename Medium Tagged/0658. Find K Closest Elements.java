// Approach Used:
// Since, the arr is already sorted we can easily apply binary search.
// We can select the range of atmost 2*k elements from the array to find k-closest elements.
// Now we have to iterate over the selected range.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int idx = Arrays.binarySearch(arr,x);
        if(idx<0)
            idx = -1*(idx+1);
        
        int j=Math.max(0,idx-k);
        
        for(int i=Math.max(0,idx-k)+k;i<Math.min(idx+k,arr.length);i++)
        {              
            if(Math.abs(arr[j]-x)>Math.abs(arr[i]-x))
                j++;
            else
            {
                for(int p=j;p<j+k;p++)
                    res.add(arr[p]);
                return res;
            }
        }
        for(int p=j;p<j+k;p++)
            res.add(arr[p]);
        return res;
    }
}
