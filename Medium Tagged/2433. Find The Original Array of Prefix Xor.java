class Solution {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        res[0]=pref[0];
        int xor = pref[0];
        for(int i=1;i<pref.length;i++)
        {
            res[i]=xor^pref[i];
            xor^=res[i];
        }
        return res;
    }
}
