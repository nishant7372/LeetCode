class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i=0;i<tiles.length();i++)
            freq[tiles.charAt(i)-'A']++;
        Set<String> a = new HashSet<>();
        generate(a,tiles,"",freq,new int[26]);
        return a.size();
    }
    
    private void generate(Set<String> a,String tiles,String temp,int[] freq,int[] freq1)
    {
        if(temp.length()!=0)
        a.add(temp);
        for(int i=0;i<tiles.length();i++)
        {
            if((freq1[tiles.charAt(i)-'A'])<(freq[tiles.charAt(i)-'A']))
            {
                freq1[tiles.charAt(i)-'A']++;
                generate(a,tiles,temp+tiles.charAt(i),freq,freq1);
                freq1[tiles.charAt(i)-'A']--;
            }
        }    
    }
}
