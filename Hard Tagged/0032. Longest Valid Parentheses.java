class Solution {
    public int longestValidParentheses(String s) {
      
        Stack<Character> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int c,max,max2,last,open,close;
        c=max=max2=last=open=close=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push('(');
                list.add(c);
                open++;
            }
            else
            {
                close++;
                if(st.empty())
                    c=0;
                else
                {
                    st.pop();
                    c+=2;
                    list.remove(list.size()-1);
                }   
            }
            if(close>open)
            {
                max2=Math.max(max2,i-last);
                close=open=0;
                last=i+1;
            }  
            max=Math.max(c,max);
        }
        int max3=max2;
        max2=0;
        if(list.size()>1)
        {
            list.add(max);
            for(int i=list.size()-1;i>0;i--)
            {
                if(list.get(i)-list.get(i-1)>max2)
                    max2=list.get(i)-list.get(i-1);
            }
        }
        if(max2==0)
            return max;
        return Math.max(max2,max3);
    }
}
