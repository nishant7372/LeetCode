// 0ms runtime Beats 100% 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1+n2;
        int[] a = new int[n];
         
        int i=0, j=0, k=0;
        while(i<n1&&j<n2)
           a[k++] = nums1[i]<=nums2[j]? nums1[i++]: nums2[j++];
        
        while(i<n1)
            a[k++]=nums1[i++];
        
        while(j<n2)
            a[k++]=nums2[j++];
        
        return n%2==0? (double)(a[n/2]+a[(n/2)-1])/2:a[n/2];
    }
}
