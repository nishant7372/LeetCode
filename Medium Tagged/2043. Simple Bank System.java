class Bank {
    long[] b;
    public Bank(long[] b) {
        this.b=b;
    }
    
    public boolean transfer(int a1, int a2, long m) {
        if(a1<=b.length&&a2<=b.length&&b[a1-1]>=m)
        {
             b[a2-1]+=m;
             b[a1-1]-=m;
             return true;
        }
        return false;
    }
    
    public boolean deposit(int a, long m) {
        if(a<=b.length)
        {
            b[a-1]+=m;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int a, long m) {
        if(a<=b.length&&b[a-1]>=m)
        {
            b[a-1]-=m;
            return true;
        }
        return false;
    }
}
