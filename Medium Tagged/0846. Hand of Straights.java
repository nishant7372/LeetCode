class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map = new TreeMap<>();
        
        for(int x:hand)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int control=0;
        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        int last = 0;
        int count=0;
        for(int i=0;i<key.size();i++)
        {
            if(count<groupSize){
            if(count==0 || key.get(i)-last==1){
                last=key.get(i);
                count++;
                map.put(key.get(i),map.get(key.get(i))-1);
                if(map.get(key.get(i))==0)
                control++;
            }
            else{
                return false;
            }
            }
            if(count==groupSize){
                i=control-1;
                count=0;
            }
        }
        return count==0? true: false;
    }
}
