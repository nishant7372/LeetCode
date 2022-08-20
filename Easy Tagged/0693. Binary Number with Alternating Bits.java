//Recursive
class Solution {
    public boolean hasAlternatingBits(int n) {
        return check(n/2,n%2);
    }
    
    private boolean check(int n,int curr)
    {
        if(n==0)
            return true;
        if(n%2==curr)
            return false;
        return convert(n/2,n%2);
    }
}


//Iterative
class Solution {
    public boolean hasAlternatingBits(int n) {
        return check(n/2,n%2);  
    }
    
    private boolean check(int n,int curr)
    {
        while(n>0)
        {
            if(curr == n%2)
                return false;
            curr=n%2;
            n/=2;
        }
        return true;
    }
}
