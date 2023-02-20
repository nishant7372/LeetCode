class Solution {
    public int minMaxDifference(int num) {
        StringBuilder s = new StringBuilder(Integer.toString(num));
        int i=0;
        while(i<s.length() && s.charAt(i)=='9'){
            i++;
        }
        int j=0;
        while(j<s.length() && s.charAt(j)=='0'){
            j++;
        }

        String s1="", s2="";
        for(int k=0;k<s.length();k++){
            if(i!=s.length() && s.charAt(k)==s.charAt(i))
                s1+='9';
            else
                s1+=s.charAt(k);
            if(j!=s.length() && s.charAt(k)==s.charAt(j))
                s2+='0';
            else
                s2+=s.charAt(k);
        }
        return Integer.parseInt(s1)-Integer.parseInt(s2);
    }
}
