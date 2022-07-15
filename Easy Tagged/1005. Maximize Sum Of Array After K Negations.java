class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        boolean zero=false;
        int sum=0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        int firstpos=101;
        for(int x:nums)
        {
            if(x<0)
                a.add(x);
            else if(x==0)
                zero=true;
            else if(x>0)
            {
                if(firstpos==101)
                    firstpos=x;
                sum+=x;
            }
        }
            
        for(int x:a)
        {
            if(k>0)
            {
            sum+=Math.abs(x);
            k--;
            }
            else
            {
               sum+=x;
            }
        }
        
        if(k>0)
        {
         if(zero)
            return sum;
         else
         {
            if(k%2==1)
            {
                if(a.size()>0&&firstpos!=101)
                {
                    sum-=2*Math.min(Math.abs(a.get(a.size()-1)),firstpos);
                }
                else if(a.size()>0)
                {
                    sum-=2*Math.abs(a.get(a.size()-1));
                }
                else if(firstpos!=101)
                {
                    sum-=2*firstpos;
                }
            }
            
         }
        }
        return sum;
    }
}
