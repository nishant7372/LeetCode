class ATM {
        long[] notes;
        int[] r;
    public ATM() {
        notes=new long[5];
        r=new int[]{20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        int i=0;
        for(int x:banknotesCount)
            notes[i++]+=x;
    }
    
    public int[] withdraw(int amount) {
        int[] res = new int[5];
        
        for(int i=4;i>=0;i--)
        {
            if(amount>=r[i])
            {
                res[i]=(int)Math.min(amount/r[i],notes[i]);
                amount-=res[i]*r[i];
            }
        }
        if(amount==0)
        {
            for(int i=0;i<5;i++)
            {
                notes[i]-=res[i];
            }
            return res;
        }
        return new int[]{-1};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
