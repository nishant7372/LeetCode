class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] a = new int[s.length()+1];
        
        for(int[] shift: shifts)
        {
            fill(a,shift[0],shift[1],shift[2]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(i>0)
                a[i]+=a[i-1];
            a[i]%=26;
            if(s.charAt(i)+a[i]<97)
                sb.append((char)(s.charAt(i)+26+a[i]));
            else if(s.charAt(i)+a[i]>122)
                sb.append((char)(s.charAt(i)-26+a[i]));
            else
                sb.append((char)(s.charAt(i)+a[i]));
        }
        return sb.toString();
    }
    
    private void fill(int[] a,int start,int end, int shift)
    {
        if(shift==0){
        a[start]--;
        a[end+1]++;
        }
        else{
        a[start]++;
        a[end+1]--;
        }   
    }
}
