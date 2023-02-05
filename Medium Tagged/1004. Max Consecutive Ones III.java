// Method 1 -->  Beats 74% (Clean and Concise)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0, zero=0, j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
               zero++;  
            while(zero>k){
                if(nums[j++]==0)
                   zero--;
            }
            max=Math.max(max,i-j+1); 
        }
        return max;
    }
}


// Method 2 -->  Beats 99.6% 

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;  // maxLength
        int zero=0;  //zeroes-count
        int j=-1;     //lower bound for window
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0){
                zero++;
            }
            if(zero>k){
                max = Math.max(max,i-j-1);
                while(nums[++j]!=0);
                zero--;
            }    
        }
        return Math.max(max,nums.length-j-1);
    }
}
