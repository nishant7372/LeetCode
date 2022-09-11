//Method 1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c=0;
       for(int i=0;i<32;i++)
       {
           if((n&1)==1)
           {
              c++; 
           }
           n=n>>1;
       }
        return c;
    }
}

//Method 2
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c=0;
       String s=Integer.toBinaryString(n);
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)=='1')
           c++;
       }
        return c;
    }
}
