class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                st.push(i);
            if(s.charAt(i)==')')
            {
                if(!st.isEmpty())
                    st.pop();
                else
                    list.add(i);
            }
        }
        int j=0;
        int k=0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(j<st.size()&&i==st.get(j))
            {
                j++;
                continue;
            }
            if(k<list.size()&&i==list.get(k))
            {
                k++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
