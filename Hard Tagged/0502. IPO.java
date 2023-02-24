// Priority Queue + Sorting -> O(nlogn) time + O(n) space
// 114ms runtime 
// Beats 43%

// Each time we have to choose the maxProfit project from the available projects

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] project = new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            project[i][0]=profits[i];
            project[i][1]=capital[i];
        }

        // capital - Increasing order
        Arrays.sort(project,(p1,p2)->Integer.compare(p1[1], p2[1]));

        // Project with maxProfit will be at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p2[0],p1[0]));

        int j=0;
        while(true){
            while(j<project.length && project[j][1]<=w)
                pq.add(project[j++]);
            
            // no project avaialable to choose
            if(pq.isEmpty() || k--==0)
               return w;
            w+=pq.remove()[0]; // adding profit to capital
        }
    }
}
