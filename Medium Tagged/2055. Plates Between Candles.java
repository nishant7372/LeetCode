class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] a=new int[queries.length];
        ArrayList<Integer> list = new ArrayList<>();
        int[] pSum = new int[s.length()];
        
        int plates=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
                plates++;
            pSum[i]=plates;
            if(s.charAt(i)=='|')
                list.add(i);
        }
        int i=0;
        for(int[] x: queries)
        {
            int start = search1(x[0],list);
            if(start==-1){
                a[i++]=0;
                continue;
            }
            int end = search2(x[1],list);
            if(start>end || end==-1)
                a[i++]=0;
            else
                a[i++]=pSum[end]-pSum[start];
        }
        return a;
    }
    
    private int search1(int idx,ArrayList<Integer> list)
    {
        int start = 0;
        int end = list.size()-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(list.get(mid)<idx){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        if(start==list.size())
            return -1;
        return list.get(start);
    }
    
    private int search2(int idx,ArrayList<Integer> list)
    {
        int start = 0;
        int end = list.size()-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(list.get(mid)>idx){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        if(end==-1)
            return -1;
        return list.get(end);
    }
}
