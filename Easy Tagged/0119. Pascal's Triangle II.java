class Solution {
    public List<Integer> getRow(int rowIndex) {
       
        ArrayList<Integer> dp = new ArrayList<>();
        ArrayList<Integer> dp2 =new ArrayList<>();
        dp.add(1);
        int n=1;
        while(n!=rowIndex+1)
        {
            dp2.add(1);
            for(int i=0;i<dp.size()-1;i++)
            {
               dp2.add(dp.get(i)+dp.get(i+1));
            }
            dp2.add(1);
            n++;
            dp.clear();
            for(int i=0;i<dp2.size();i++)
                dp.add(dp2.get(i));
            dp2.clear();
        }
        return dp;
    }
}
