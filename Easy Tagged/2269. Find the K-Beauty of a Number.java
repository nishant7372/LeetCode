// 0ms runtime Beats 100% (Sliding Window)

class Solution {
    public int divisorSubstrings(int num, int k) {
        int c=0;
        String s=Integer.toString(num);
        for(int i=0;i<s.length()-k+1;i++)
        {
            int a = Integer.parseInt(s.substring(i,i+k));
            if(a>0&&num%a==0)
                c++;
        }
        return c;
    }
}
