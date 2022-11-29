class Solution {
    public long appealSum(String s) {
        int[] a = new int[26];
        long c=0;
        long ans=0;
        for(int i=0;i<s.length();i++)
        {
            c-=a[s.charAt(i)-'a'];
            ans+=c+=a[s.charAt(i)-'a']=i+1;
        }
        return ans;
    }
}
