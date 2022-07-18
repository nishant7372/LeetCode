class Solution {
    public int maximumSum(int[] nums) {
      ArrayList<Integer>[] a= new ArrayList[82];
      for(int i=0;i<a.length;i++)
          a[i]=new ArrayList<Integer>();
        
        for(int x:nums)
        {
            a[sum(x)].add(x);
        }
        int max=-1;
        for(ArrayList<Integer> x:a)
        {
            Collections.sort(x);
            if(x.size()>1 && x.get(x.size()-1)+x.get(x.size()-2)>max)
                max=x.get(x.size()-1)+x.get(x.size()-2);
        }
    
        return max;
    }
    
    
    private int sum(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}
