// Beats 99% O(n) solution

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> a = new ArrayList<Integer>();
        int[] lIndex = new int[26];
        
        for(int i=0;i<26;i++)
            lIndex[i]=s.lastIndexOf((char)(i+'a'));
        
        int index=0;
        int lastIndex=lIndex[s.charAt(index)-'a'];
        while(index<s.length())
        {
            for(int i=index;i<lastIndex;i++)
                lastIndex = Math.max(lastIndex,lIndex[s.charAt(i)-'a']);
    
            a.add(lastIndex-index+1);
            index=lastIndex+1;
            
            if(lastIndex+1<s.length())
                lastIndex=lIndex[s.charAt(index)-'a'];
        }
        return a;
    }
}
