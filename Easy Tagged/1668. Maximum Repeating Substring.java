class Solution {
    public int maxRepeating(String s, String word) {
        int max=0;
        char[] arr = s.toCharArray();
        char[] w = word.toCharArray();
        for(int i=0;i<s.length();i++){
            max=Math.max(max,check(arr,i,w));
        }
        return max;
    }

    private int check(char[] arr,int start,char[] w){
        int idx=0;
        int k=0;
        for(int i=start;i<arr.length;i++){
            if(arr[i]==w[idx])
                idx++;
            else
                return k;
            if(idx==w.length){
                k++;
                idx=0;
            }
        }
        return k;
    }
}
