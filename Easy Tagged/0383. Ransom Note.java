class Solution {
    public boolean canConstruct(String ran, String mag) {
        int[] freq = new int[26];
        for(int i=0;i<mag.length();i++)
            freq[mag.charAt(i)-'a']++;
        
        for(int i=0;i<ran.length();i++){
            if(freq[ran.charAt(i)-'a']--<=0)
                return false;
        }
        return true;
    }
}
