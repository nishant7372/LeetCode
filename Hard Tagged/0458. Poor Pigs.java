class Solution {
    public int poorPigs(int buckets, int m, int n) {
        return (int)Math.ceil(Math.log10(buckets)/Math.log10((n/m)+1));
    }
}
