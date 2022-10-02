class LUPrefix {
    int[] a;
    int idx=1;
    public LUPrefix(int n) {
        this.a = new int[n+2];
    }
    
    public void upload(int video) {
        a[video] = 1;
        while(a[idx]==1){
            idx++;
        }
    }
    
    public int longest() {
        return idx-1;
    }
}
