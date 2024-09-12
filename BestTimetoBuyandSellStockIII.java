// Time Complexity : O(n) 
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {

    	// minimize
        int buyingPrice1 = Integer.MAX_VALUE; 
        int buyingPrice2 = Integer.MAX_VALUE; 

        // maximize
        int profit1 = 0;
        int profit2 = 0; 

        for(int price: prices) {
        	// 2 transactions
        	// buy1/sell1/buy2/sel2
        	buyingPrice1 = Math.min(buyingPrice1, price);
        	profit1 = Math.max(profit1, price - buyingPrice1);
        	// transaction 2; reinvesting profit1
        	// effective
        	buyingPrice2 = Math.min(buyingPrice2, price - profit1);
        	profit2 = Math.max(profit2, price - buyingPrice2);

        }

        return profit2;
    }
}