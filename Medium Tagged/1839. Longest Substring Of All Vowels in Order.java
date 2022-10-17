class Solution {
    public int longestBeautifulSubstring(String word) {
        int max=0;
        for(int i=0;i<word.length()-1;i++)
        {
            if(word.charAt(i)=='a')
            {
               int j=i;
                boolean e,I,o;
                e=I=o=false;
            while(j<word.length()-1 && word.charAt(j+1)>=word.charAt(j))
            {
                if(word.charAt(j)=='e')
                    e=true;
                if(word.charAt(j)=='i')
                    I=true;
                if(word.charAt(j)=='o')
                    o=true;
                j++;
            }
            if(word.charAt(j)=='u' && I && e && o)
            {
                max=Math.max(max,j-i+1);
            }
                i=j;
            }
        }
        return max;
    }
}
