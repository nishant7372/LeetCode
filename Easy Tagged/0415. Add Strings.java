//Method 1
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer s = new StringBuffer();
        int diff = Math.abs(num2.length()-num1.length());
        if(num1.length()<num2.length())
        {
            num1="0".repeat(diff)+num1;
        }
        if(num2.length()<num1.length())
        {
            num2="0".repeat(diff)+num2;
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
        return s.reverse().toString();
    }
}


//Method 2
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer s = new StringBuffer();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum=0;
        int carry=0;
        while(i>=0||j>=0)
        {
            if(i>=0&&j>=0)
            {
                sum=(num1.charAt(i)-'0'+num2.charAt(j)-'0'+carry);
            }
            else if(i<0)
            {
                sum=(num2.charAt(j)-'0'+carry);
            }
            else if(j<0)
            {
                sum=(num1.charAt(i)-'0'+carry);
            }
            carry=sum/10;
            s.append(sum%10);
            i--;
            j--;
        }
        if(carry>0)
            s.append(carry);
        return s.reverse().toString();
    }
}
