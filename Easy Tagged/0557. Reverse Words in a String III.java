//Method 1 - using StringBuffer
class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer(s);
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' '){
                reverse(sb,j,i-1);
                j=i+1;
            }
        }
        reverse(sb,j,s.length()-1);  //for last word
        return sb.toString();
    }
    
    
    private void reverse(StringBuffer sb,int start,int end)
    {
        while(start<end)
        {
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}

//Method 2 - using stack
class Solution {
    public String reverseWords(String s) {
        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                while(!st.isEmpty())
                    sb.append(st.pop());
                sb.append(" ");
            }
            else
                st.push(s.charAt(i));
        }
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }
}
