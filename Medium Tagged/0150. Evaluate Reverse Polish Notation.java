class Solution {
    static int top=-1;
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("*")) 
                st.push(st.pop()*st.pop());
            
            else if(tokens[i].equals("-"))
            {
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }
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
