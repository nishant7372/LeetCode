class Solution {
    public int[] rearrangeArray(int[] a) {
       int[] nums = new int[a.length];
       int i=0;
       int j=1;
       for(int x:a)
       {
           if(x>0)
           {
           nums[i]=x;
               i+=2;
           }
           else
           {
           nums[j]=x;
           j+=2;
           }
       }
       return nums;
    }
}
