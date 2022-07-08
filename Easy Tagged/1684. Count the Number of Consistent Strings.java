class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int k=0; //Consistent String Count
        int[] a = new int[26];
        for(int i=0;i<allowed.length();i++)
        {
            a[allowed.charAt(i)-'a']=1;
        }
        for(String s:words)
        {
            int c=0;
            for(int i=0;i<s.length();i++)
            {
                if(a[s.charAt(i)-'a']==0)
                    break;
                c++;
            }
            if(c==s.length())
            k++;
        }
        return k;
    }
}
