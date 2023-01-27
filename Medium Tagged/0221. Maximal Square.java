//Method 1 --> Using Stack (Implementation similar to 85. Maximal Rectangle(Hard Tagged))

class Solution {
    public int maximalSquare(char[][] matrix) {
        // based on prev and next smaller element.
        // but here we are considering each col as an individual array.

        //Step 1 .Compute prefix sum for each row.
        int m = matrix.length, n = matrix[0].length;
        int[][] mat = new int[m][n];

        for(int i=0;i<m;i++){
            mat[i][0]=matrix[i][0]-'0';
            for(int j=1;j<n;j++){
                if(matrix[i][j]!='0')
                   mat[i][j]+=mat[i][j-1]+1;
                else
                   mat[i][j]=0;
            }
        }
        
        //Step 2. Compute maxSide for each col.
        int max=0;
        for(int col=0;col<n;col++){
            max=Math.max(max,computeMax(col,mat));
        }
        
        return max*max;
    }


    private int computeMax(int col,int[][] mat){
        int m = mat.length;
        Stack<int[]> st = new Stack<>();
        int[] prevSmaller = new int[m];
        int[] nextSmaller = new int[m];

        //Step 2.1. Find index of prev smaller width for each width, mat[i][col]
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0]>mat[i][col]){
                prevSmaller[st.pop()[1]]=i;
            }
            st.push(new int[]{mat[i][col],i});
        }
        while(!st.isEmpty()){
            prevSmaller[st.pop()[1]]=-1;
        }

        //Step 2.2 .Find index of next smaller width for each width, mat[i][col]
        for(int i=0;i<m;i++){
            while(!st.isEmpty() && st.peek()[0]>mat[i][col]){
                nextSmaller[st.pop()[1]]=i;
            }
            st.push(new int[]{mat[i][col],i});
        }
        while(!st.isEmpty()){
            nextSmaller[st.pop()[1]]=m;
        }

        
        //Step 2.3. Compute maxSide for column col.

        //finding maxSide from side(converting rectangle to square) of each rectangle of width, mat[i][col] and height (nextSmaller[i]-prevSmaller[i]-1)
        int max=0;
        for(int i=0;i<m;i++){
            int side = Math.min(mat[i][col],nextSmaller[i]-prevSmaller[i]-1);
            max=Math.max(max,side);
        }

        return max;

    }
}
