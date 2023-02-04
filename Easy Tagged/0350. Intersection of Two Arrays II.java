class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] f = new int[1001];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int x:nums1)
            f[x]++;
        
        for(int x:nums2)
        {
            if(f[x]-->0)
               list.add(x);
        }
        
        int[] res = new int[list.size()];
        int k=0;
        for(int x:list)
            res[k++]=x;
        return res;
    }
}
