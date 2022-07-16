class Solution {
    public int romanToInt(String s) {
        int prev = func(s.charAt(0));
        int ans=prev;
    for(int i=1;i<s.length();i++)
    {
        int curr=func(s.charAt(i));
        if(prev<curr)
            ans+=(curr-prev)-prev;
        else
            ans+=curr;
        prev=curr;
    }
       return ans; 
    }
    
    private int func(char ch)
    {
    switch(ch)
    {
        case 'I':return 1;
        case 'V':return 5;
        case 'X':return 10;
        case 'L':return 50;
        case 'C':return 100;
        case 'D':return 500;
        case 'M':return 1000; 
    }
        return 0;
    }
}
