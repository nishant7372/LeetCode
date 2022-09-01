class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor)
		     fill(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    
    private void fill(int[][] image,int i,int j,int newColor,int prevColor)
    {
        if(i==-1||j==-1||i==image.length||j==image[i].length||image[i][j]!=prevColor)
             return;
        image[i][j]=newColor;
        fill(image,i+1,j,newColor,prevColor);
        fill(image,i,j+1,newColor,prevColor);
        fill(image,i-1,j,newColor,prevColor);
        fill(image,i,j-1,newColor,prevColor);
    }
}
