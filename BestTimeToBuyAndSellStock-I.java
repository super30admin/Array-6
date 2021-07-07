//time o(n)
//space o(1)
class Solution {
    int min = Integer.MAX_VALUE;
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int profit =0;
        for(int price : prices) {
            min = Math.min(price, min);
            profit = Math.max(profit, price-min);
        }
        return profit;
    }
}