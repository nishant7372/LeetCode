class Solution {
    public boolean isCircularSentence(String s) {
        String[] a = s.split(" ");
        
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i].charAt(a[i].length()-1)!=a[i+1].charAt(0))
                return false;
        }
        
        if(a[0].charAt(0)!=a[a.length-1].charAt(a[a.length-1].length()-1))
            return false;
        return true;
    }
}
