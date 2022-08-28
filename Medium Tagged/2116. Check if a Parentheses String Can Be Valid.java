class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1)
            return false;
        Stack<Integer> st = new Stack<>();
        Deque<Integer> unlocked = new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            if(locked.charAt(i)=='1'&&s.charAt(i)=='(')
                st.push(i);
            else if(locked.charAt(i)=='0')
                unlocked.add(i);
            else if(locked.charAt(i)=='1'&&s.charAt(i)==')')
            {
                if(!st.isEmpty())
                    st.pop();
                else
                {
                    if(unlocked.isEmpty())
                        return false;
                    unlocked.removeFirst();
                }
            }
        }
        while(!st.isEmpty())
        {
            if(unlocked.isEmpty()||unlocked.removeLast()<st.pop())
                return false;
        }
        return true;
    }
}
