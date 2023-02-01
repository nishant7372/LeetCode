// Method 1 --> 1ms runtime Beats 85.83% (Matching prefix of length gcd with substrings of both s and t)

class Solution {
    public String gcdOfStrings(String s, String t) {
        int gcd = gcd(s.length(),t.length());
        if(check(s.substring(0,gcd),s,t))
            return s.substring(0,gcd);
        return "";
    }

    private int gcd(int a,int b){
        if(a==0)
           return b;
        if(b==0 || a==b)
           return a;
        if(a>b)
           return gcd(a-b,b);
        return gcd(a,b-a);
    }

    private boolean check(String p,String s,String t){
        int j=p.length();
        for(int i=0;i<s.length();i+=j){
            if(!s.substring(i,i+j).equals(p)){
                return false;
            }
        }
        for(int i=0;i<t.length();i+=j){
            if(!t.substring(i,i+j).equals(p)){
                return false;
            }
        }
        return true;
    }
}

// Method 2 --> 1ms runtime Beats 85.83% (Matching prefix of length gcd with both s and t (no substring))

class Solution {
    public String gcdOfStrings(String s, String t) {
        int gcd = gcd(s.length(),t.length());
        if(check(gcd,s,t))
            return s.substring(0,gcd);
        return "";
    }

    private int gcd(int a,int b){
        if(a==0)
           return b;
        if(b==0 || a==b)
           return a;
        if(a>b)
           return gcd(a-b,b);
        return gcd(a,b-a);
    }

    private boolean check(int j,String s,String t){
        for(int i=0;i<s.length();i+=j){
            if(!match(s,s,i,i+j)){
                return false;
            }
        }
        for(int i=0;i<t.length();i+=j){
            if(!match(t,s,i,i+j)){
                return false;
            }
        }
        return true;
    }

    private boolean match(String s,String p,int start,int end){
        int k=0;
        for(int i=start;i<end;i++){
            if(s.charAt(i)!=p.charAt(k))
               return false;
            k++;
        }
        return true;
    }
}
