class Solution {
    public String multiply(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        for(int i=num2.length()-1;i>=0;i--)
        {
            res = add(res,multiply(num2.charAt(i),num1).append("0".repeat(num2.length()-1-i)));
        }
        if(res.charAt(0)=='0')
            return "0";
        return res.toString();
    }
    
    
    
    private StringBuffer multiply(char x,String s)
    {
        int a = x-'0';
        StringBuffer sb = new StringBuffer();
        int carry=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            int sum = (s.charAt(i)-'0')*a+carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        if(carry!=0)
            sb.append(carry);
        return sb.reverse();
    }
    
    
    private StringBuffer add(StringBuffer num1,StringBuffer num2)
    {
        StringBuffer s = new StringBuffer();
        int diff = Math.abs(num2.length()-num1.length());
        if(num1.length()<num2.length())
        {
            num1.reverse();
            num1.append("0".repeat(diff));
            num1.reverse();
        }
        if(num2.length()<num1.length())
        {
            num2.reverse();
            num2.append("0".repeat(diff));
            num2.reverse();
        }
        int carry=0;
        for(int i=num2.length()-1;i>=0;i--)
        {
            int sum=(num1.charAt(i)-'0'+num2.charAt(i)-'0')+carry;
            carry = sum/10;
            s.append(sum%10);
        }
        if(carry!=0)
        s.append(carry);
        return s.reverse();
    }
}
