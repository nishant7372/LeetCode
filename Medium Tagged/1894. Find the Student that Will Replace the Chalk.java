class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int x:chalk)
            sum+=x;
        long a = k%sum;
        int i=0;
        for(int x:chalk)
        {
            a-=x;
            if(a<0)
                return i;
            i++;
        }
        return i;
    }
}
