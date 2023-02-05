// 12ms runtime Beats 85%

// Keep a window of size k and maintain the number of vowels in it.
// Keep moving the window and update the number of vowels while moving. Answer is max number of vowels of any window.

class Solution {
    public int maxVowels(String s, int k) {
        int c=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i)))
                c++;
        }
        int max=c;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i)))
                c++;
            if(isVowel(s.charAt(i-k)))
                c--;
            max=Math.max(max,c);
        }
        return max;
    }
    
    private boolean isVowel(char a)
    {
        if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u')
            return true;
        return false;
    }
}
