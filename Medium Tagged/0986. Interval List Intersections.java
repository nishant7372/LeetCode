class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> resList = new ArrayList<>();
       for(int[] interval:firstList)
       {
           for(int[] interval2:secondList)
           {
               int[] res = new int[2];
               res[0]=Math.max(interval[0],interval2[0]);
               res[1]=Math.min(interval[1],interval2[1]);
               if(res[1]-res[0]>=0)
                   resList.add(res);
           }
       }
        int k=0;
        int[][] resArray = new int[resList.size()][2];
        for(int[] x:resList)
            resArray[k++]=x;
        
        return resArray;
    }
}
