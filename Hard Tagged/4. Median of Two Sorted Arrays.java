class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int[] a = new int[n];
         
        int k=0;
        int j=0;
        int i=0;
        while(k<n1&&j<n2)
        {
           if(nums1[k]<=nums2[j])
           {
               a[i++]=nums1[k];
               k++;
           }
           else if(nums1[k]>nums2[j])
           {
               a[i++]=nums2[j];
               j++;
           }
        }
        while(k<n1)
        {
            a[i++]=nums1[k];
            k++;
        }
        while(j<n2)
        {
            a[i++]=nums2[j];
            j++;
        }
        return n%2==0? (double)(a[n/2]+a[(n/2)-1])/2:a[n/2];
    }
}
