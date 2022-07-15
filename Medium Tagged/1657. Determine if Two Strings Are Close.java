class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()==word2.length())
        {
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<word1.length();i++)
        {
            a[word1.charAt(i)-'a']++;
            b[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
        if(a[i]>0&&b[i]==0||b[i]>0&&a[i]==0)
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
         
        if(Arrays.equals(a,b))
            return true;
        }
        return false;
    }
}
