class Solution {
    public int numberOfBeams(String[] bank) {
        int sum=0, prev=0;
        for(String x:bank){
            int c=0;
            for(char ch:x.toCharArray()){
                c+=(ch-'0');
            }
            if(c>0){
                sum+=(c*prev);
                prev=c;
            }
        }
        return sum;
    } 
}
