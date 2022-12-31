class Solution {
    public int[] getOrder(int[][] taskArray) {
        int[][] tasks = new int[taskArray.length][3];
        for(int i=0;i<tasks.length;i++)
            tasks[i]=new int[]{taskArray[i][0],taskArray[i][1],i};

        Arrays.sort(tasks,(a,b) -> a[0]==b[0]? Integer.compare(a[1],b[1]): Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]==b[1]? Integer.compare(a[2],b[2]):Integer.compare(a[1],b[1]));

        int k=0, i=0, time = tasks[i][0];
        int[] res = new int[tasks.length];
        while(i<tasks.length){
            while(i<tasks.length && tasks[i][0]<=time)
                pq.add(tasks[i++]);
            if(!pq.isEmpty()){
                int[] curr = pq.remove();
                res[k++]=curr[2];
                time+=curr[1];
            }
            else
                time=tasks[i][0];
        }
        while(!pq.isEmpty()){
            res[k++]=pq.remove()[2];
        }
        return res;
    }
}
