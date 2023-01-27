// Method 1 --> 0ms runtime Beats 100%

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

// Method 2  --> 1ms runtime Beats 44.26%

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int c=0;
       for(int i=0;i<32;i++)
       {
           if((n&1)==1)
              c++;
           n=n>>1;
       }
       return c;
    }
}

// Method 3  --> 1ms runtime Beats 44.26%

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int c=0;
       String s=Integer.toBinaryString(n);
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='1')
              c++;
       }
       return c;
    }
}

// Method 4  --> 3ms runtime Beats 5.5%

public class Solution {
    // you need to treat n as an unsigned value
    int c=0;
    public int hammingWeight(int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        if(n>=0){
           convert(n,a);
           return count(a,1,0,0);
        }
        else{
            convert(Math.abs(n),a);
            convert2s(a);
            return 32-count(a,0,0,0);    
        }  
    }
    
    private void convert(int n,ArrayList<Integer> a)
    {
        if(n==0)
            return;
        convert(n/2,a);
        a.add(n%2);
    }
    
    private int count(ArrayList<Integer> a,int target,int c,int i)
    {
       if(i==a.size())
           return c;
       if(a.get(i)==target)
           c++;
       return count(a,target,c,++i);
    }
    
    private void convert2s(ArrayList<Integer> a)
    {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)==0)
                a.set(i,1);
            else
                a.set(i,0);
        }
        a.set(a.size()-1,(a.get(a.size()-1)+1)%2);
        int rem = (a.get(a.size()-1)==0)? 1:0;
        for(int i=a.size()-2;i>=0;i--)
        {
            if(rem==0)
                break;
            int sum=a.get(i)+rem;
            rem=sum/2;
            sum=sum%2;
            a.set(i,sum);
        }
    }
}
