/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //Find Peak Element
        int low = 0;
        int high = mountainArr.length()-1;
        while(low<high)
        {
            int mid = (low+high)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1))
                low=mid+1;
            else
                high=mid;
        }
        int peakIndex=low;
        
        
        //Search in 1st Half
        low=0;
        high=peakIndex;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int element = mountainArr.get(mid);
            if(element<target)
                low=mid+1;
            else if(element==target)
                return mid;
            else
                high=mid-1;
        }
        
        //Search in 2nd Half
        low=peakIndex+1;
        high=mountainArr.length()-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int element = mountainArr.get(mid);
            if(element>target)
                low=mid+1;
            else if(element==target)
                return mid;
            else
                high=mid-1;
        }
        
        //If Not Found return -1
        return -1;
    }
}
