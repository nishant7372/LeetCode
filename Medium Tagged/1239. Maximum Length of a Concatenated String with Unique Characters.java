//Using HashTable to store Frequencies
class Solution {
    private int max=0;
    public int maxLength(List<String> arr) {
        generate(arr,0,"",new int[26]);
        return max;
    }
    
    private void generate(List<String> arr,int index,String temp,int[] freq)
    {
        if(temp.length()>max)
            max=temp.length();
        for(int i=index;i<arr.size();i++)
        {
            if(canBeUsed(arr.get(i),freq))
            {
                increment(arr.get(i),freq);
                generate(arr,i+1,temp+arr.get(i),freq);
                decrement(arr.get(i),freq);
            }    
        } 
    }
    
    private boolean canBeUsed(String s,int[] freq)
    {
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']!=0||s.indexOf(s.charAt(i))!=s.lastIndexOf(s.charAt(i)))
                return false;
        }
        return true;
    }
    
    private void increment(String s,int[] freq)
    {
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
    }
    
    private void decrement(String s,int[] freq)
    {
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']--;
    }
}

//-------------------------------------------------------------------------------------------------------//
//Using String.IndexOf()
class Solution {
    private int max=0;
    public int maxLength(List<String> arr) {
        generate(arr,0,"");
        return max;
    }
    
    private void generate(List<String> arr,int index,String temp)
    {
        if(temp.length()>max)
            max=temp.length();
        for(int i=index;i<arr.size();i++)
        {
            if(canBeUsed(arr.get(i),temp))
                generate(arr,i+1,temp+arr.get(i));
        } 
    }
    
    private boolean canBeUsed(String s,String temp)
    {
        for(int i=0;i<s.length();i++){
            if(temp.indexOf(s.charAt(i))>=0||s.indexOf(s.charAt(i))!=s.lastIndexOf(s.charAt(i)))
                return false;
        }
        return true;
    }
}
