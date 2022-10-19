class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=2;i<=n;i++)
        {
            s=say(s);
        }
        return s;
    }
    
    private String say(String s)
    {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            int c=1;
            while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1))
            {
                i++;
                c++;
            }
            sb.append(c);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
