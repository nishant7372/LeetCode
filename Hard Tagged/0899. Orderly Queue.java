class Solution {
    public String orderlyQueue(String s, int k) {
        String res;
        if(k==1){
            res=s;
            for(int i=0;i<s.length();i++)
            {
                String temp = s.substring(i,s.length())+s.substring(0,i);
                if(temp.compareTo(res)<0)
                    res=temp;
            }
        }
        else{
            int[] a = new int[26];
            
            for(int i=0;i<s.length();i++)
            {
                a[s.charAt(i)-'a']++;
            }
            
            res="";
            for(int i=0;i<a.length;i++)
            {
                res+=((char)(i+'a')+"").repeat(a[i]);
            }
        }
        return res;
    }
}
