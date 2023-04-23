class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] a = new int[101];
        int[] res = new int[nums.length-k+1];
      
        int m=0;
        for(int i=0;i<k;i++)
        {
            a[nums[i]+50]++;
        }
        res[m++] = find(a,x);
        
        for(int i=k;i<nums.length;i++)
        {
            a[nums[i-k]+50]--;
            a[nums[i]+50]++;
            res[m++] = find(a,x);
        }
        return res;
    }
    
    
    private int find(int[] a,int x){
        int i=0;
        while(x>0 && i<a.length){
            x-=a[i];
            if(x<=0 && i<50){
                return i-50;
            }
            if(i>50 && x>0){
                return 0;
            }
            i++;
        }
        return 0;
    }
}
