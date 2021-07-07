// Time Complexity : O(N)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice1=Integer.MAX_VALUE, buyingPrice2=Integer.MAX_VALUE, profit1=0, profit2=0;
        for(int price : prices) {
            buyingPrice1=Math.min(buyingPrice1, price);
            profit1=Math.max(profit1, price-buyingPrice1);
            
            buyingPrice2=Math.min(buyingPrice2, price-profit1);
            profit2=Math.max(profit2, price-buyingPrice2);
        }
        return profit2;
    }
}
