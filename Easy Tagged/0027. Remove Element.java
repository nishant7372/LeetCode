class Solution {
    public int removeElement(int[] arr, int val) {
        int k=0;
        for(int x:arr)
        {
            if(x!=val)
            {
                arr[k++]=x;
            }
        }
        return k;
    }
}
