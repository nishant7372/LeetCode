class MyLinkedList {
    int val;
    MyLinkedList next; //next = link
    MyLinkedList root; //root = head/front
    MyLinkedList rear; 
    int l;     // length of linked list
    public MyLinkedList() {
      l=0;
      root=null;
      rear=root;
    }
    
     public MyLinkedList(int data) {
      this.val=data;
      this.next=null;
    }
    
    public int get(int index) {
        if(index<0||index>=l)
            return -1;
        MyLinkedList temp=root;
        while(index-->0)
            temp=temp.next;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        if(root==null){
            rear=newNode;
        }
        newNode.next=root;
        root=newNode;
        l++;
    }
    
    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        if(root==null){
            root=newNode;
            rear=root;
        }
        else{
            rear.next=newNode;
            rear=rear.next;
        }
        l++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0)
            addAtHead(val); 
        else if(index==l)
            addAtTail(val);
        else if(index>0&&index<l){
            MyLinkedList newNode = new MyLinkedList(val);
            MyLinkedList curr = root;
            MyLinkedList prev = root;
            while(index-->0){
                prev=curr;
                curr=curr.next;
            }   
            newNode.next=curr;
            prev.next=newNode;
            l++;
        }  
    }
    
    public void deleteAtIndex(int index) {
        MyLinkedList curr = root;
        MyLinkedList prev = root;
        if(index==0){
            root=root.next;
            l--;
        }
        else if(index>0&&index<l){
            while(index-->0){
                prev=curr;
                curr=curr.next;
            }   
            if(curr==rear)
                rear=prev;
            prev.next=curr.next;
            l--;
        }
    }
}
