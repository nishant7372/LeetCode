class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> st = new Stack<>();
        boolean[] unlocked = new boolean[rooms.size()];
        int roomsUnlocked=0;
        st.push(0);   //Initially we have key for room 0
        while(!st.isEmpty()){
            int currentkey = st.pop();   //current room key
            if(!unlocked[currentkey]){   //if current room is not unlocked then we enter it and collect all the keys
                for(int x: rooms.get(currentkey))
                    st.push(x);
                roomsUnlocked++;
                unlocked[currentkey]=true;   //unlocking the room with currentkey
            }
        }
        
        //If after unlocking all the rooms with available keys, there is any room which is unlocked return false
        if(roomsUnlocked<rooms.size())
            return false;
        return true;
    }
}
