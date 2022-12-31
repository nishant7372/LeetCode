class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        
        for(int x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        int control=0;
        int last = 0;
        int count=0;
        for(int i=0;i<key.size();i++)
        {
            if(count<k){
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
            if(count==k){
                i=control-1;
                count=0;
            }
        }
        return count==0? true: false;
}
}
