class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;   //day of buying the stock
        int sell=0;  //day of selling the stock
        int maxProfit=0;  
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]-prices[i-1]>0){
                sell=i;
            }
            else{
                if(buy<sell)
                maxProfit+=prices[sell]-prices[buy];
                
                buy=i;
            }
        }
        if(buy<sell)
            maxProfit+=prices[sell]-prices[buy];
        
        return maxProfit;
    }
}
