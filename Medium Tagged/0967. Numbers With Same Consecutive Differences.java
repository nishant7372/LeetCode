class Solution {
    private ArrayList<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        generate(nums,n,0,k,0);
        int[] res = new int[list.size()];
        int i=0;
        for(int x:list)
            res[i++]=x;
        return res;
    }
    
    private void generate(int[] nums,int n,int temp,int k,int i)
    {
        if(i==n){
            list.add(temp);
            return;
        }
        for(int x:nums)
        {
            if(temp>0){
                if(Math.abs(temp%10-x)==k)
                    generate(nums,n,temp*10+x,k,i+1);
            }
            else{
                if(x!=0)
                    generate(nums,n,temp*10+x,k,i+1);
            } 
        }
    }
}
