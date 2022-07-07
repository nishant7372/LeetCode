class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        generate(0,n,0,k,res,new int[k]);
        return res;
    }
    
    private void generate(int i,int n,int sum,int k,List<List<Integer>> res,int[] num)
    {
        if(i==k)
        {
            if(sum==n)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int x:num)
                    temp.add(x);
                res.add(temp);
            }
            return;
        }
        
        for(int j=(i==0)?1:num[i-1]+1;j<=9;j++)
        {
            num[i]=j;
            generate(i+1,n,sum+j,k,res,num);
        }
    }
}
