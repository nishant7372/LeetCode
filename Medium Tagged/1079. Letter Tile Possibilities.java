// Method 1 --> 40ms runtime Beats 35% (Basic Approach)

class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        boolean[] visited = new boolean[tiles.length()];
        Set<String> set = new HashSet<>();
        generate(set,arr,"",visited);
        return set.size();
    }
    
    private void generate(Set<String> set,char[] tiles,String temp,boolean[] visited)
    {
        if(temp.length()!=0)
           set.add(temp);
        
        int i=0;
        for(char ch:tiles)
        {
            if(!visited[i]){
                visited[i]=true;
                generate(set,tiles,temp+ch,visited);
                visited[i]=false;
            }
            i++;
        }    
    }
}

// Method 2 --> 115ms runtime Beats 10% (Basic Approach)

class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        int[] freq = new int[26];
        for(char ch:arr)
            freq[ch-'A']++;
        Set<String> set = new HashSet<>();
        generate(set,arr,"",freq,new int[26]);
        return set.size();
    }
    
    private void generate(Set<String> set,char[] tiles,String temp,int[] total,int[] freq)
    {
        if(temp.length()!=0)
           set.add(temp);
        for(char ch:tiles)
        {
            if(freq[ch-'A']<total[ch-'A'])
            {
                freq[ch-'A']++;
                generate(set,tiles,temp+ch,total,freq);
                freq[ch-'A']--;
            }
        }    
    }
}
