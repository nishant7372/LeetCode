//Beats 100% 0ms runtime

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips=0;
        while(a>0 || b>0 || c>0){
            if(c%2==1)
                flips+=flips1(a%2,b%2);
            else
                flips+=flips2(a%2,b%2);
            c/=2;
            a/=2;
            b/=2;
        }
        return flips;
    }

    private int flips1(int a,int b){
        if(a==1||b==1)
           return 0;
        else
           return 1;
    }

    private int flips2(int a,int b){
        if(a==1&&b==1)
           return 2;
        else if(a==1||b==1)
           return 1;
        else
           return 0;
    }
}
