// Beats 79%

class Solution {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        int x=1;
        while(true){
            if(Arrays.binarySearch(nums,x)<0)
               return x;
            x+=x;
        }  
    }
}
