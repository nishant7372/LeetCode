class Solution {
    public int maxPower(String s) {
        int max =1;
        int c=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
               c++;
            else{
                max=Math.max(c,max);
                c=1;
            }
        }
        return Math.max(c,max);
    }
}
