class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1)
            return new int[]{};
        int max=0;
        for(int x:changed)
            if(x>max)
                max=x;
        int[] freq = new int[max+1];
    
        for(int x:changed)
            freq[x]++;
        
        int[] res = new int[changed.length/2];
        int j=0;
        
        for(int i=0;i<freq.length;i++)
        {
            while(freq[i]-->0){
                if(2*i<freq.length&&freq[2*i]>0)
                   freq[2*i]--;
                else 
                    return new int[]{};
                res[j++]=i;
            }
        }
        return res;
    }
}
