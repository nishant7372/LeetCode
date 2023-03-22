// Depth First Search
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return solve(arr,start,vis);
    }
    
    private boolean solve(int[] arr,int i,boolean[] vis)
    {
        if(i>=arr.length||i<0||vis[i])
            return false;
        if(arr[i]==0)
            return true;
        vis[i] = true;
        return solve(arr,i+arr[i],vis) || solve(arr,i-arr[i],vis);
    }
}

// Breadth First Search
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(curr>=arr.length||curr<0||vis[curr])
                continue;
            if(arr[curr]==0){
                return true;
            }
            vis[curr]=true;
            queue.add(curr+arr[curr]);
            queue.add(curr-arr[curr]);
        }
        return false;
    }
}
