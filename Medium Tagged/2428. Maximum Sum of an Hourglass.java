class Solution {
    public int maxSum(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]+=grid[i][j-1];
            }
        }
        
        int max,i,j;
        max=i=j=0;
        while(i<grid.length-2)
        {
            int sum=0;
            if(j==0)
                sum=grid[i][j+2]+grid[i+1][j+1]-grid[i+1][j]+grid[i+2][j+2];
            else
                sum=grid[i][j+2]-grid[i][j-1]+grid[i+1][j+1]-grid[i+1][j]+grid[i+2][j+2]-grid[i+2][j-1];
            j++;
            if(sum>max)
                max=sum;
            if(j==grid[0].length-2){
                j=0;
                i++;
            } 
        }
        return max;
    }
}
