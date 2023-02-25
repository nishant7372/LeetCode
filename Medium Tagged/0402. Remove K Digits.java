class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char ch: num.toCharArray()){
            while(!st.isEmpty() && st.peek()>ch && k>0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        StringBuffer sb = new StringBuffer();

        int i=0;
        while(i<st.size() && st.get(i)=='0'){
            i++;
        }
        for(int j=i;j<st.size()-k;j++){
            sb.append(st.get(j));
        }

        return sb.isEmpty()? "0": sb.toString();
    }
}
