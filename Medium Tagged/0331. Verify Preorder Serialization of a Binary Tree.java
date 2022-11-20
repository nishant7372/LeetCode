class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack<>();
        
        String[] a = preorder.split(",");
        
        for(String s:a)
        {
            while(st.size()>=2 && s.equals("#") && st.peek().equals("#") && !st.get(st.size()-2).equals("#")){
                st.pop();
                st.pop();
            }
            st.push(s);
        }
        if(st.size()==1 && st.peek().equals("#"))
            return true;
        return false;
    }
}
