class Solution {
    public List<String> commonChars(String[] words) {
        List<String> a = new ArrayList<>();
        int[] main = new int[26];
        Arrays.fill(main,Integer.MAX_VALUE);

        for(String s:words){
            int[] freq = new int[26];
            for(char ch:s.toCharArray())
                freq[ch-'a']++;
            for(int i=0;i<26;i++)
                main[i]=Math.min(main[i],freq[i]);
        }

        for(int i=0;i<26;i++){
            while(main[i]-->0){
                a.add(Character.toString((char)(i+'a')));
            }
        }
        return a;
    }
}
