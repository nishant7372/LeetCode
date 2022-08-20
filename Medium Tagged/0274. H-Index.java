class Solution {
    public int hIndex(int[] citations) {
        int max=0;
        for(int x:citations)
        {
            if(x>max)
                max=x;
        }
        int[] a = new int[max+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int x:citations)
            a[x]++;
        for(int i=0;i<a.length;i++)
        {
            while(a[i]-->0)
                list.add(i);
        }
        int start=0;
        int end=list.size()-1;
        int n = end+1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(list.get(mid)<n-mid){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return n-start;
    }
}
