class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        boolean neg = false;
        if(s.equals(""))
            return 0;
        if(s.charAt(0)=='-')
            neg=true;
        StringBuffer t = new StringBuffer("0");
        for(int i= (s.charAt(0)=='+'||s.charAt(0)=='-')? 1:0;i<s.length();i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                t.append(s.charAt(i));
            else
                break;
        }
        int a=0;
        try{
        a = Integer.parseInt(t.toString());
        }
        catch(Exception e)
        {
            if(neg)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        if(neg)
            return -1*a;
        return a;
    }
}
