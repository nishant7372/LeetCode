class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] prevIndex = new int[128];
        Arrays.fill(prevIndex,-1);
        int max, start, j;
        max=start=j=0;
        while(j<s.length())
        {
            if(prevIndex[s.charAt(j)]==-1)
                prevIndex[s.charAt(j)]=j++;
            else
            {
                max=Math.max(max,j-start);
                start = j = prevIndex[s.charAt(j)]+1;  //start of new substring
                Arrays.fill(prevIndex,-1);
            }
        }
        return Math.max(max,j-start);
    }
}
