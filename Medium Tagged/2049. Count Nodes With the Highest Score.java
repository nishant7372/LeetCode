class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length; // no. of nodes
        
        //for storing left and right child of each node
        ArrayList<Integer>[] a = new ArrayList[n];
        
        for(int i=0;i<n;i++)
            a[i]=new ArrayList<Integer>();
        
        for(int i=1;i<n;i++)
            a[parents[i]].add(i);
        
        //store total number of children of each node
        int[] child = new int[n]; 
        Arrays.fill(child,-1);
        
        dfs(0,a,child); //calculating all childrens at each node
    
        //storing scores of each node
        long[] scores = new long[a.length];
        
        long maxScore=0; //maxScore
        
        for(int i=0;i<n;i++)
        {
            long res=1; // calculating score for a particular node
            for(int y:a[i])
                res*=child[y]+1;
            
            res*=Math.max(1,n-child[i]-1);
            scores[i]=res;
            if(res>maxScore)
                maxScore=res;
        }
    
        int c=0; // count of maxScores
        for(long score:scores)
            if(score==maxScore)
                c++;
        
        return c;
    }
    
    private int dfs(int x,ArrayList<Integer>[] a,int[] child)
    {
        int c=0;
        for(int y:a[x])
            c+=dfs(y,a,child);

        return child[x]=c+a[x].size();
    }
}
