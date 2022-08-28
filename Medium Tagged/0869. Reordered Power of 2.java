class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s=n+"";
        int[] a = new int[10];   // frequency of digits in number n
        for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'0']++;

        int i=1;
        String t = "1";  
        while(s.length()>=t.length())
        {
            if(s.length()==t.length()){
            int[] b = new int[10];     // frequency of digits in number m
                
            for(int j=0;j<t.length();j++)
                b[t.charAt(j)-'0']++;
                
            if(Arrays.equals(a,b))
                return true;
            }
            t = (int)Math.pow(2,i++)+"";
        }
        return false;
    }  
}
