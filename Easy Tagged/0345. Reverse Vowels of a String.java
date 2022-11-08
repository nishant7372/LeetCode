class Solution {
    public String reverseVowels(String sb) {
        StringBuilder s =new StringBuilder(sb);
        Set<Character> a = new HashSet<>();
        a.add('a');
        a.add('e');
        a.add('i');
        a.add('o');
        a.add('u');
        a.add('A');
        a.add('E');
        a.add('I');
        a.add('O');
        a.add('U');
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            while(i<j && !a.contains(s.charAt(i)))
                i++;
            while(i<j && !a.contains(s.charAt(j)))
                j--;
            char temp = s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,temp);
            i++;
            j--;
        }
        return s.toString();
    }
}
