class MyQueue {
    ArrayList<Integer> stack1;
    ArrayList<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayList<Integer>();
        stack2 = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack1.add(0,x);
        if(stack1.size()>0)
        {
            stack2.add(stack1.get(0));
        }
        stack1.remove(0);
    }
    
    public int pop() {
        return stack2.remove(0);
    }
    
    public int peek() {
        return stack2.get(0);
    }
    
    public boolean empty() {
        if(stack2.size()==0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
