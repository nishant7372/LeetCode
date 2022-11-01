class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long number=0;
        long a=10;
        boolean flag=true; //number not found till flag true
        while(flag){
            if(isBeautiful(n,target))
                return number;
            long temp = a-(n%a);  //making number divisible by 10^n
            n+=temp;
            number+=temp;
            a=a*10;
        }
        return -1;
    }
    
    private boolean isBeautiful(long n,int target)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum<=target? true:false;
    }
}
