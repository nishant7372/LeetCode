class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> a= new ArrayList<List<Integer>>();
        a.add(new ArrayList<Integer>());
        a.get(0).add(1);
        int n=1;
        while(n!=numRows)
        {
            a.add(new ArrayList<Integer>());
            a.get(n).add(1);
            for(int i=0;i<a.get(n-1).size()-1;i++)
            {
               a.get(n).add(a.get(n-1).get(i)+a.get(n-1).get(i+1));
            }
            a.get(n).add(1);
            n++;
        }
        return a;
    }
}
