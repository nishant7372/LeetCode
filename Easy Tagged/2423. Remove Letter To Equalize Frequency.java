// 0ms runtime and Beats 100% 

class Solution {
    public boolean equalFrequency(String word) {
        int[] a = new int[26];
        
        for(char ch:word.toCharArray())
            a[ch-'a']++;
        
        int max=0;
        int min=word.charAt(0)-'a';

        for(int i=0;i<a.length;i++)
        {
            if(a[i]>a[max])
                max=i;
            if(a[i]<a[min] && a[i]>0)
                min=i;
        }
        //checking by reducing max freq by 1
        a[max]--;
        if(check(a))
            return true;
        a[max]++;
        
        //checking by reducing min freq by 1
        a[min]--;
        if(check(a))
             return true;
        return false;
    }
    
    private boolean check(int[] a)
    {
        int last=0;
        for(int x:a)
        {
            if(x>0){
                if(last==0)
                   last=x;
                else if(last!=x)
                   return false;
            }
        }
        return true;
    }
}
