class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length()/rows;
        char[][] mat = new char[rows][cols];
        
        int k=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j] = encodedText.charAt(k++);
            }
        }
       
        StringBuffer s = new StringBuffer();
        k=0;
        while(k++<cols)
        {
            int i=0;
            int j=k-1;
            while(i<rows && j<cols)
                s.append(mat[i++][j++]);
        }
        int m=s.length()-1;
        while(m>=0 && s.charAt(m)==' ')
            m--;
        return s.substring(0,m+1);
    }
}
