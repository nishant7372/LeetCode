class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] incomingEdge = new boolean[n];
        
        //Conting the nodes with zero incoming edges
        List<Integer> res= new ArrayList<>();
        for(List<Integer> list:edges){
            incomingEdge[list.get(1)]=true;
        }
        
        int i=0;
        for(boolean b:incomingEdge){
            if(!b)
                res.add(i);
            i++;
        }
        
        return res;
    }
}
