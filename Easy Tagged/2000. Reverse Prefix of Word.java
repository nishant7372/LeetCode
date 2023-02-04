// Method 1 -> 0ms runtime Beats 100%

class Solution {
    public String reversePrefix(String word, char ch) {
        
        int j = word.indexOf(ch);
        if(j==-1)
            return word;
        char[] arr = word.toCharArray();
        reverse(arr,0,j);
        return String.valueOf(arr);
    }

    private void reverse(char[] arr,int i,int j){
        while(i<j){
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}

// Method 2 -> 1ms runtime Beats 60%

class Solution {
    public String reversePrefix(String word, char ch) {
        
        int j = word.indexOf(ch);
        if(j==-1)
            return word;
        StringBuffer sb = new StringBuffer(word.substring(0,j+1));
        
        return sb.reverse().toString()+word.substring(j+1,word.length());
    }
}
