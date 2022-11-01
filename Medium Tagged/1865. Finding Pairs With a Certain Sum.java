class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer,Integer>  map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        this.map = new HashMap<>();
        for(int x:nums2)
            map.put(x,map.getOrDefault(x,0)+1);
    }
    
    public void add(int index, int val) {
        int b = nums2[index];
        nums2[index]+=val;
        map.put(b,map.get(b)-1);
        map.put(b+val,map.getOrDefault(b+val,0)+1);
    }
    
    public int count(int tot) {
        int c=0;
        for(int x:nums1)
        {
            c+=map.getOrDefault(tot-x,0);
        }
        return c;
    }
}
