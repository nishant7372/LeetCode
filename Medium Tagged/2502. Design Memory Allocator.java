class Allocator {
    ArrayList<int[]>[] map;
    int[] a;
    int[] map2;
    public Allocator(int n) {
        a = new int[n];
        map = new ArrayList[1001];
        map2 = new int[n];
        
        for(int i=0;i<1001;i++)
            map[i] = new ArrayList<>();
    }
    
    public int allocate(int size, int mID) {
        int c=0;
        int index=0;
        int i=0;
        while(i<a.length)
        {
            if(map2[i]==0){
                c++;
                i++;
            }
            else{
                i+=map2[i];
                c=0;
                index=i;
            }
            if(c==size)
            {
                map[mID].add(new int[]{index,size});
                map2[index]=size;
                return index;
            }
        }
        return -1;
    }
    
    public int free(int mID) {
        int size=0;
        for(int[] x:map[mID]){
            map2[x[0]]=0;
            size+= x[1];
        }
        map[mID] = new ArrayList<>();
        return size;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
