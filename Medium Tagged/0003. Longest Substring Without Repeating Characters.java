//Sliding Window --> O(96*n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[96];
        int max, i, j;
        max=i=j=0;
        while(j<s.length())
        {
            a[s.charAt(j++)-32]++;
            while(containsDuplicate(a)){
                a[s.charAt(i++)-32]--;
            }
            max=Math.max(max,j-i);
        }
        return max;
    }

    private boolean containsDuplicate(int[] arr){
        for(int x:arr){
            if(x>1)
               return true;
        }
        return false;
    }
}


// Method 2 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] prevIndex = new int[96];
        Arrays.fill(prevIndex,-1);
        int max, start, j;
        max=start=j=0;
        while(j<s.length())
        {
            if(prevIndex[s.charAt(j)-32]==-1)
                prevIndex[s.charAt(j)-32]=j++;
            else
            {
                max=Math.max(max,j-start);
                start = j = prevIndex[s.charAt(j)-32]+1;  //start of new substring
                Arrays.fill(prevIndex,-1);
            }
        }
        return Math.max(max,j-start);
    }
}
