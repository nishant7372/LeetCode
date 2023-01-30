// 0ms runtime Beats 100%

class Solution {
    public int numberOfMatches(int n) {
        int match=0;
        while(n!=1){
        if(n%2==0){
            match=match+(n/2);
            n=n/2;
        }
        else{
           match=match+(n/2);
           n=(n/2)+1;  
        }
        }
        return match;
    }
}
