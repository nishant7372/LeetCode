// Beats 78% 

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] temp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        
        int j=1;
        for(int x:temp){
            if(map.get(x)==null){
               map.put(x,j);
               j++;
            }
        }

        int i=0;
        for(int x:arr)
            arr[i++]=map.get(x);

        return arr;
    }
}
