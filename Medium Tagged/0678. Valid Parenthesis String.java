class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Deque<Integer> star = new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                st.push(i);
            else if(s.charAt(i)=='*')
                star.add(i);
            else
            {
                if(!st.isEmpty())
                    st.pop();
                else
                {
                    if(star.isEmpty())
                        return false;
                    star.removeFirst();
                }
            }
        }
        while(!st.isEmpty())
        {
            if(star.isEmpty()||star.removeLast()<st.pop())
                return false;
        }
        return true;
    }
}
