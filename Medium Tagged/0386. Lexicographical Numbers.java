class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            a.add(Integer.toString(i));
        }
        Collections.sort(a);
        for(int i=0;i<a.size();i++)
        {
            res.add(Integer.parseInt(a.get(i)));
        }
        return res;
    }
}
