class Solution {
    public int countSubstrings(String s) {
        int c=s.length();

        for(int i=0;i<s.length();i++)
        {
            c+=func(i,i+1,s);
            if(i>0)
            c+=func(i-1,i+1,s);
        }
        
        return c;
    }
    
    private int func(int j,int k,String s)
    {
        int c=0;
        while(j>=0&&k<s.length())
        {
            if(s.charAt(j--)!=s.charAt(k++))
                break;
            c++;
        }
        return c;
    }
}
