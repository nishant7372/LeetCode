// 0ms runtime beats 100%

class Solution {
    public int countOdds(int low, int high) {
        return (high-low)/2 + (low%2==0 && high%2==0)? 0:1);
    }
}
