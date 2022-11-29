class Solution {
    public long countVowels(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        long c=0;
        long sum=0;
        for(int i=0;i<word.length();i++)
        {  
            if(set.contains(word.charAt(i)))
                c+=(i+1);
            sum+=c;
        }   
        return sum;
    }
}
