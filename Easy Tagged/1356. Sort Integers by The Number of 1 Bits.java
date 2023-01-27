// 10ms runtime Beats 58.48%

class Solution {
    public int[] sortByBits(int[] arr) {
    List<List<Integer>> a = new ArrayList<>();
        for(int i=0;i<15;i++)
            a.add(new ArrayList<Integer>());
        
        for(int x:arr)
            a.get(countOnes(x)).add(x);
        
        int k=0;
        for(List<Integer> list:a){
            Collections.sort(list);
            for(int x:list)
                arr[k++]=x;
        }
        return arr;
    }
    
    private int countOnes(int n)
    {
        int c=0;
        while(n>0){
            if(n%2==1)
               c++;
            n/=2;
        }
        return c;
    }
}
