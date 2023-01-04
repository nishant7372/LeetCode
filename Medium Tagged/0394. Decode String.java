class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuffer res=new StringBuffer();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==']')
            {
                StringBuffer sb = new StringBuffer();
                while(st.peek()!='[')
                    sb.append(st.pop()); 
                st.pop();
                
                StringBuffer sb2 = new StringBuffer();
                while(!st.isEmpty()&&st.peek()<='9'&&st.peek()>='0')
                    sb2.append(st.pop());
                
                sb2.reverse();
                sb.reverse();
                int n = Integer.parseInt(sb2.toString());
                while(n-->0)
                {
                    for(int j=0;j<sb.length();j++)
                        st.push(sb.charAt(j));
                }
            }   
            else
                st.push(s.charAt(i));
        }
        for(int i=0;i<=st.size()-1;i++)
        res.append(st.get(i)); 
    
        return res.toString();
    }
}
