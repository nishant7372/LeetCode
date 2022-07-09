class Solution {
    public int reverse(int x) {
        long ans = rev(x,0);
        return (ans > Integer.MAX_VALUE||ans < Integer.MIN_VALUE)? 0:(int)ans;
	}

	private long rev(int n,long rev)
	{
		if(n==0)
		return rev;
		return rev(n/10,rev*10+n%10);
	}
}
