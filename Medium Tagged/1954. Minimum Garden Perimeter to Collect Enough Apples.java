//Method 1--> Linear Search

class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long sum=0;
        long m=0;
        long n=0;
        while(sum<neededApples)
        {
            m++;
            sum=12*m*m;
            sum+=n;
            n=sum;
        }
        return 8*m;
    }
}
