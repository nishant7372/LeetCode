class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("*")) 
                st.push(st.pop()*st.pop());
            
            else if(tokens[i].equals("-"))
                st.push(-1*(st.pop()-st.pop()));
            
            else if(tokens[i].equals("+"))
                st.push(st.pop()+st.pop());
    
            else if(tokens[i].equals("/"))
            {
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();
    }
}
