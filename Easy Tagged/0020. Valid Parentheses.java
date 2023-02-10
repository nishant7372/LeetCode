// 1ms runtime, Beats 99.23%, O(n) time and O(n) space 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
      
        for(char ch:s.toCharArray())
        {
            if(ch=='('||ch=='['||ch=='{')
                st.push(ch);
            else
            {
                if(st.empty())
                    return false;
                else if(ch==')'&&st.peek()!='(')
                    return false;
                else if(ch==']'&&st.peek()!='[')
                    return false;
                else if(ch=='}'&&st.peek()!='{')
                    return false;
                st.pop();
            }
        }
        return st.empty();
    }
}
