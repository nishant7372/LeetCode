// Method 1 --> 0ms runtime Beats 100% (Matching prefix of length gcd with substrings of both s and t)

class Solution {
    public String gcdOfStrings(String s, String t) {
        int gcd = gcd(s.length(),t.length());
        String p = s.substring(0,gcd);  // prefix string of length= gcd(s.length(),t.length())
        if(check(p,s) && check(p,t))
            return p;
        return "";
    }

    private int gcd(int a,int b){
        return a==0? b:gcd(b%a,a);
    }

    private boolean check(String p,String s){
        int j=p.length();
        for(int i=0;i<s.length();i+=j)
            if(!s.substring(i,i+j).equals(p))
                return false;
        return true;
    }
}


// Method 2 --> 1ms runtime Beats 85.83% (Matching prefix of length gcd with both s and t (no substring))

class Solution {
    public String gcdOfStrings(String s, String t) {
        int gcd = gcd(s.length(),t.length());
        if(check(gcd,s,s) && check(gcd,t,s))
            return s.substring(0,gcd);   // prefix string of length= gcd(s.length(),t.length())
        return "";
    }

    private int gcd(int a,int b){
        return a==0? b:gcd(b%a,a);
    }

    private boolean check(int j,String s,String p){
        for(int i=0;i<s.length();i+=j)
            if(!match(s,p,i,i+j))
                return false;
        return true;
    }

    private boolean match(String s,String p,int start,int end){
        int k=0;
        for(int i=start;i<end;i++)
            if(s.charAt(i)!=p.charAt(k++))
               return false;
        return true;
    }
}
