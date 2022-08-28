class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                st.push(0);
            else
            {
                int a = 0;
                while(st.peek()!=0)
                    a+=st.pop();
                st.pop();
                st.push(Math.max(1,2*a));
            }
        }
        int score=0;
        while(!st.isEmpty()){
            score+=st.pop();
        }
        return score;
    }
}
