// 60ms runtime Beats 63.2% (Doubly LinkedList)

class BrowserHistory {
    ListNode root;
    ListNode curr;
    public BrowserHistory(String homepage) {
        this.root = new ListNode(homepage);
        this.curr = root;
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        if(curr.next!=null)
           curr.next.prev=null;
        curr.next=newNode;
        newNode.prev=curr;
        curr=curr.next;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps-->0){
            curr=curr.prev;
        }
        return curr.val;
        
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps-->0){
            curr=curr.next;
        }
        return curr.val;
    }
}

class ListNode{
    String val;
    ListNode prev;
    ListNode next;
    public ListNode(String val){
        this.val = val;
        prev=null;
        next=null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
