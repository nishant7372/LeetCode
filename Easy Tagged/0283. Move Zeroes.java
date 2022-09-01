class Solution {
    public void moveZeroes(int[] a) {
        int k=0;
		for(int x:a)
		{
			if(x!=0)
                a[k++]=x;
		}
        Arrays.fill(a,k,a.length,0);
	}
}
