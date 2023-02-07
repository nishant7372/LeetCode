// Method 1 -> O(n) time and O(1) space Beats 68% 2ms runtime

class Solution {
    public int maxProfit(int[] prices) {
       int minPrice = prices[0];
       int maxProfit=0;
       for(int x:prices)
       {
           if(x<minPrice)
               minPrice=x;
	        if(x-minPrice>maxProfit)
	           maxProfit=x-minPrice;
       }
       return maxProfit;
    }
}

// Method 2 -> O(n) time and O(n) space Beats 68% 2ms runtime

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] futureProfit = new int[n+1];
        int max=0;
        for(int i=n-1;i>=0;i--)
            futureProfit[i] = max = Math.max(max,prices[i]);
        
        int i=0, maxProfit=0;
        for(int x:prices)
            maxProfit = Math.max(maxProfit,futureProfit[++i]-x);
        
        return maxProfit;
    }
}

