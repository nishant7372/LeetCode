// 9ms runtime, Beats 94%

class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        int count=1;
        for(char ch:s.toCharArray())
        {
            if(freq[ch-'a']==1){
                count++;
                Arrays.fill(freq,0);
            }
            freq[ch-'a']++;
        }
        return count;
    }
}
