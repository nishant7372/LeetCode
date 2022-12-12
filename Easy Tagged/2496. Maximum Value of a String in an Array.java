class Solution {
    public int maximumValue(String[] strs) {
        int max=0;
        for(String s:strs)
        {
            try{
                int a = Integer.parseInt(s);
                max=Math.max(a,max);
            }
            catch(Exception e)
            {
                max=Math.max(s.length(),max);
            }
        }
        return max;
    }
}
