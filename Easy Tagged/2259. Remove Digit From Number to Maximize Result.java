class Solution {
    public String removeDigit(String n, char digit) {
        for(int i=n.indexOf(digit);i<n.length()-1;i++)
        {
            if(n.charAt(i)==digit&&n.charAt(i)<n.charAt(i+1))
            return n.substring(0,i)+n.substring(i+1,n.length());
        }
        int j = n.lastIndexOf(digit);
        return n.substring(0,j)+n.substring(j+1,n.length());
    }
}
