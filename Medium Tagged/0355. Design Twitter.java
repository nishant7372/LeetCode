// 10ms runtime Beats 90% (Doubly LinkedList)

class Twitter {
    ListNode root;
    boolean[][] a;
    public Twitter() {
        a = new boolean[501][501];
        root = null;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(root==null){
            root=new ListNode(userId,tweetId);
        }
        else{
            ListNode newPost = new ListNode(userId,tweetId);
            root.next = newPost;
            newPost.prev=root;
            root = root.next;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = root;
        int count=10;
        while(curr!=null && count>0){
            if(curr.userId == userId || a[userId][curr.userId]){
               list.add(curr.tweetId);
               count--;
            }
            curr=curr.prev;
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        a[followerId][followeeId]=true;
    }
    
    public void unfollow(int followerId, int followeeId) {
        a[followerId][followeeId]=false;
    }
}

class ListNode{
    int userId;
    int tweetId;
    ListNode next;
    ListNode prev;

    public ListNode(int userId,int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
        this.prev=null;
        this.next=null;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
