// Method 1 --> 9ms runtime Beats 91% Optimized solution (Counting Sort)

class Solution {
    int idx;
    public int minDeletions(String s) {
        int[] freq = new int[26]; // element -> frequency
        int max=0;
        for(char ch: s.toCharArray()){
            if(++freq[ch-'a']>max)
            max=freq[ch-'a'];
        }
        
        int[] a = new int[max+1]; // frequencies --> no. of elements
        for(int x:freq){
            if(x>0)
               a[x]++;
        }
        idx=max;
        
        int c=0;
        while(idx>0){
            fixDuplicates(a);
            c++;
        }

        return c-1;
    }
    
    private void fixDuplicates(int[] a)
    {
        while(idx>0 && a[idx]<=1){
            idx--;
        }

        if(idx>0){
           a[idx]--;
           a[idx-1]++;
        }
    }
}

// Method 2 --> nlogn Sorting Solution Beats 40% 

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
     ArrayList<Integer> a = new ArrayList<Integer>();
        
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        
        for(int x:freq)
        if(x!=0)
            a.add(x);
        
        int c=0;
        Collections.sort(a);
        while(containsDuplicate(a))
        {
        for(int i=1;i<a.size();i++)
        {
            if(a.get(i).equals(a.get(i-1)))
            {
                if(a.get(i)!=1)
                a.set(i,a.get(i)-1);
                else
                a.remove(i);
                c++;
            }     
        }
        Collections.sort(a);
        }
        return c;
    }
    
    private boolean containsDuplicate(ArrayList<Integer> a)
    {
        for(int i=0;i<a.size()-1;i++)
        {
            if(a.get(i).equals(a.get(i+1)))
                return true;
        }
        return false;
    }
}
