class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int maxTime=logs[0][1];
        int id=logs[0][0];
        for(int i=1;i<logs.length;i++)
        {
           if(logs[i][1]-logs[i-1][1]>=maxTime){
               if(logs[i][1]-logs[i-1][1]==maxTime){
                   if(id>logs[i][0]){
                   id = logs[i][0];
                   }
               }
               else{
                   maxTime = logs[i][1]-logs[i-1][1];
                   id = logs[i][0];
               }
           }
        }
        return id;
    }
}
