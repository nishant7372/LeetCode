class Solution {
    ArrayList<Integer> order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] list = new ArrayList[numCourses];
		
		//Making Adjacency List
        for(int i=0;i<numCourses;i++)
            list[i] = new ArrayList<Integer>();
        
        for(int[] prerequisite: prerequisites)
            list[prerequisite[0]].add(prerequisite[1]);
        
        int[] visited = new int[numCourses];  //for cycle detection
        Integer[] canTaken = new Integer[numCourses]; // to compute whether a course can be taken or not
  
        Arrays.fill(canTaken,null);
        
        order = new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(list,i,visited,canTaken)==0)  //if particular course cannot be taken
                return new int[]{};
        }
        
        int[] resArray = new int[order.size()];
        int i=0;
        for(int x:order)
            resArray[i++]=x;
        return resArray;
    }
    
    private int dfs(ArrayList<Integer>[] list,int course,int[] visited,Integer[] canTaken)
    {
        if(canTaken[course]!=null)  //if res is already computed return it
            return canTaken[course];
        if(visited[course]==1)  //if cycle for a particular course repeated, course cannot be taken
            return 0;
        boolean res = true;
        visited[course]=1;
        for(int x:list[course])   //checking for each course (computing res)
        {
            res = res && dfs(list,x,visited,canTaken)==1? true:false;
            if(!res)   // if course cannot be taken
                return canTaken[course]=0;   
        }
        visited[course]=0;
        order.add(course);
        return canTaken[course]= res? 1:0;
    }
   
}
