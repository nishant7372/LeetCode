//Approach 1 -> Using counter

class Solution {
    public int longestContinuousSubstring(String s) {
        int max=1, c=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1)-1)
                c++;
            else{
                max=Math.max(max,c); //update max
                c=1;
            }
        }
        return Math.max(max,c);
    }
}

//Approach 2 -> Without using counter

class Solution {
    public int longestContinuousSubstring(String s) {
        int i=0, j=1, max=0;
        while(j<s.length()){
            if(s.charAt(j-1)+1!=s.charAt(j)){
                max = Math.max(max,j-i);  //update max
                i=j;
            }
            j++;
        }
        max = Math.max(max,j-i);
        return max;
    }
}
