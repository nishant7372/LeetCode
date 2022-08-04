class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(res,2*n,"",0,0);   
        return res;
    }
    
    private void generate(ArrayList<String> res,int n,String part,int i,int j)
    {
        if(part.length()==n)
        {
            res.add(part);
            return;
        }
        if(i<n/2)
        generate(res,n,part+'(',i+1,j);
        if(j<i)
        generate(res,n,part+')',i,j+1); 
    }
}
