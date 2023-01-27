class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(1);
        int c=0;
        for(int i=2;i<Math.pow(2,n);i+=2)
        {
            res.add(grayCode(i,0)[1]);
            if(c%2==0)
               res.add(res.get(i)-1);
            else
               res.add(res.get(i)+1);
            c++;
        }
        return res;
    }
    
    private int[] grayCode(int n,int c)
    {
        if(n==0)
           return new int[]{0,0};
        int[] res = grayCode(n/2,c+1);
        res[1]+=((res[0]^n%2)*Math.pow(2,c));
        res[0]=n%2;
        return res;
    }
}
