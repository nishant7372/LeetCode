class Solution {
    public boolean winnerOfGame(String s) {
        int Alice,Bob,a,b;
        Alice=Bob=a=b=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='A'){
                if(b-2>0)
                    Bob+=b-2;
                b=0;
                a++;
            }
            else if(s.charAt(i)=='B'){
                if(a-2>0)
                    Alice+=a-2;
                a=0;
                b++;
            }
        }
        if(a-2>0)
            Alice+=a-2;
        if(b-2>0)
            Bob+=b-2;
        if(Alice>Bob)
            return true;
        return false;
    }
}
