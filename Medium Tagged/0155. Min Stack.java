class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.size()==0){
            minSt.push(val);
        }
        else if(val<=getMin())
            minSt.push(val);
    }
    
    public void pop() {
        if(getMin()==st.pop())
            minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
