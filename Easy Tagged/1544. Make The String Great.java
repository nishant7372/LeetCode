class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(!st.isEmpty() && (s.charAt(i)==st.peek()+32 || s.charAt(i)==st.peek()-32))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<st.size();i++)
            res.append(st.get(i));
        return res.toString();
    }
}
