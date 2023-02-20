// Two pointers 
// Beats 100%

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] res = new int[nums1.length+nums2.length][2];
        int i=0, j=0, k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                res[k][0]=nums1[i][0];
                res[k][1]=nums1[i][1]+nums2[j][1];
                i++; j++;
            }
            else if(nums1[i][0]<nums2[j][0]){
                res[k][0]=nums1[i][0];
                res[k][1]=nums1[i][1];
                i++;
            }
            else if(nums1[i][0]>nums2[j][0]){
                res[k][0]=nums2[j][0];
                res[k][1]=nums2[j][1];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            res[k][0]=nums1[i][0];
            res[k][1]=nums1[i][1];
            k++; i++;
        }
        while(j<nums2.length){
            res[k][0]=nums2[j][0];
            res[k][1]=nums2[j][1];
            k++; j++;
        }
        return Arrays.copyOf(res,k);
    }
}
