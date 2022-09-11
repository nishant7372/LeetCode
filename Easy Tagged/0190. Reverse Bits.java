//Method 1
public class Solution {
    public int reverseBits(int n) {
        StringBuffer sb=new StringBuffer(Integer.toBinaryString(n));
        sb.reverse();
        return convert(sb);
    }
    
    private int convert(StringBuffer sb)
    {
        int sum=0;
        for(int i=0;i<sb.length();i++)
        {
            sum+=(sb.charAt(i)-'0')*(long)Math.pow(2,31-i);
        }
        return sum;
    }
}

//Method 2
public class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
