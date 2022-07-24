class Solution {
    public char repeatedCharacter(String s) {
        int[] a = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            if(a[s.charAt(i)-'a']==0)
            a[s.charAt(i)-'a']=1;
            else
                return s.charAt(i);
        }
        return 'a';
    }
}
