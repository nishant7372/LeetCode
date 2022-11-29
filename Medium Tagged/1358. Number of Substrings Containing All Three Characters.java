class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int c=0;
        int i=0;
        for(int j=0;j<s.length();j++)
        {
            freq[s.charAt(j)-'a']++;
            while(freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
                c+=s.length()-j;
                freq[s.charAt(i++)-'a']--;
            }
        }
        return c;
    }
}
